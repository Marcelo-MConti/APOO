package com.gesac.disciplinas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    // enumeradores para interface de seleção do usuário
    private static final class MenuOption {
        static final int GERENCIAR = 1;
        static final int MEDIA_DISCIPLINA = 2;
        static final int MEDIA_ATIVIDADES = 3;
        static final int EDITAR_ATIVIDADES = 4;
        static final int SAIR = 5;
    };

    private static final class CrudOption {
        static final int ADICIONAR = 1;
        static final int EDITAR = 2;
        static final int EXCLUIR = 3;
        static final int RETORNAR = 4;
    };


    // DisciplinaController funciona como um singleton
    static final DisciplinaController controller = new DisciplinaController();


    // função de utilidade para leitura da entrada do usuário
    static int readInteger(BufferedReader reader) throws IOException {
        OptionalInt value = OptionalInt.empty();

        while (value.isEmpty()) {
            try {
                value = OptionalInt.of(Integer.valueOf(reader.readLine()));
            } catch (NumberFormatException ex) {
                System.out.println(new Mensagem(TipoMensagem.ERRO, "Digite um número válido").toString());
            }
        }

        return value.orElseThrow();
    }

    // Recebe do usuário os dados que compõe uma disciplina
    // Se a disciplina já existe e estamos mudando seus dados, o argumento prev será essa disciplina
    static Disciplina readDisc(BufferedReader reader, Disciplina prev) throws IOException
     {
        Disciplina disc = prev == null ? new Disciplina() : prev;

        if (prev == null)
            System.out.print("Nome: ");
        else
            System.out.print("Nome (%s): ".formatted(prev.nome));

        disc.nome = reader.readLine();

        if (prev == null)
            System.out.println("Carga horária/qtde. de horas: ");
        else
            System.out.print("Carga horária/qtde. de horas (%d): ".formatted(prev.cargaHoraria));

        disc.cargaHoraria = readInteger(reader);

        return disc;
    }


    // Média das notas de todas as provas da Disciplina disc
    static double mediaDisc(Disciplina disc) {
        List<Atividade> atividades = disc.atividades;
        double soma = 0;
        int n = 0;

        for (Atividade ativ : atividades) {
            switch (ativ) {
                case Prova p -> {
                    soma += p.nota;
                    n++;
                }
                default -> {}
            }
        }

        // Se não há nenhuma prova (n == 0), média será 0
        double media = soma / (n != 0 ? n : 1);
        return media;
    }

    public static void main(String[] args) throws IOException {
        final String banner = ":: Sistema de Gestão Acadêmico :: Disciplinas e Turmas";

        final String options = """
        
        1. Gerenciar disciplinas
        2. Calcular a média de uma disciplina
        3. Calcular a média das atividades
        4. Editar atividades
        
        5. Sair
        """;

        System.out.println(banner);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // No loop, recebemos as opções do usuário e executamos os casos de uso, até ele selecionar "Sair"
        while (true) {
            System.out.println(options);
            int chosenOption = readInteger(reader);

            int id;
            Disciplina disc = null;

            switch (chosenOption) {
                // Na opção Gerenciar Disciplinas, o usuário fica preso nestas opções específicas deste
                // caso de uso, até selecionar "Voltar"
                case MenuOption.GERENCIAR:

                    subOptionLoop: while (true) {
                        String suboptions = """

                        Escolha uma opção.

                        1. Adicionar disciplina
                        2. Editar disciplina
                        3. Excluir disciplina

                        4. Voltar
                        """;

                        System.out.println(suboptions);
                        int chosenSubOption = readInteger(reader);
                    
                        switch (chosenSubOption) {
                            case CrudOption.ADICIONAR:
                                disc = readDisc(reader, null);
                                controller.criarDisciplina(disc);
                                break; 

                            case CrudOption.EDITAR:
                                System.out.print("Digite o ID da disciplina que você deseja editar: ");
                                
                                do {
                                    id = readInteger(reader);
                                    disc = controller.visualizarDisciplina(id);
                                } while (disc != null);

                                disc = readDisc(reader, disc);

                                System.out.println(controller.editarDisciplina(disc).toString());
                                break;

                            case CrudOption.EXCLUIR:
                                System.out.print("Digite o ID da disciplina que você deseja remover: ");

                                do {
                                    id = readInteger(reader);
                                    disc = controller.visualizarDisciplina(id);
                                } while (disc != null);

                                System.out.println(controller.removerDisciplina(id).toString());
                                break;

                            case CrudOption.RETORNAR:
                                break subOptionLoop;

                            default:
                                System.out.println(
                                    new Mensagem(TipoMensagem.ERRO, "Opção inválida: %d".formatted(chosenSubOption)).toString()
                                );
                                break;
                        }
                    }
                    break;

                // Nesta opção, o usuário escolhe uma disciplina por seu ID e recebe a média das provas dela.
                case MenuOption.MEDIA_DISCIPLINA:
                    System.out.print("Digite o ID da disciplina cuja média será calculada: ");
                    
                    do {
                        id = readInteger(reader);
                        disc = controller.visualizarDisciplina(id);
                    } while (disc != null);

                    double media = mediaDisc(disc);
                    System.out.println(
                        new Mensagem(TipoMensagem.SUCESSO, "Média da disciplina: %lf".formatted(media)).toString()
                    );
                    break;

                case MenuOption.MEDIA_ATIVIDADES:
                    // List<Disciplina> disciplinas = controller.repository.listarTodas();

                    // double mediaAtiv = 0;
                    // int n = disciplinas.size();

                    // for (Disciplina d : disciplinas) {
                    //     mediaAtiv += mediaDisc(d);
                    // }

                    // mediaAtiv /= (n != 0 ? n : 1);
                    // System.out.println(
                    //     new Mensagem(TipoMensagem.SUCESSO, "Média das atividades: %lf".formatted(mediaAtiv)).toString()
                    // );
                    break;

                case MenuOption.EDITAR_ATIVIDADES:
                    // System.out.print("Digite o ID da disciplina de interesse: ");

                    // do {
                    //     id = readInteger(reader);
                    //     disc = controller.visualizarDisciplina(id);
                    // } while (disc != null);

                    // System.out.println("Qual atividade você quer editar? (0 para criar uma atividade)");

                    // XXX: print list
                    break;

                case MenuOption.SAIR:
                    System.exit(0);
                default:
                    System.out.println(new Mensagem(TipoMensagem.ERRO, "Opção inválida: %d".formatted(chosenOption)).toString());
                    break;
            }
        }
    }
}
