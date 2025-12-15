package com.gesac.disciplinas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class Main {
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
    };

    static final Mensagens msg = new Mensagens();
    static final DisciplinaController controller = new DisciplinaController();

    static int readInteger(BufferedReader reader) throws IOException {
        OptionalInt value = OptionalInt.empty();

        while (value.isEmpty()) {
            try {
                value = OptionalInt.of(Integer.valueOf(reader.readLine()));
            } catch (NumberFormatException ex) {
                System.out.println(msg.gerar(TipoMensagem.ERRO, "Digite um número válido"));
            }
        }

        return value.orElseThrow();
    }

    static double mediaDisc(Disciplina disc) {
        List<Atividade> atividades = disc.getAtividades();
        double media = 0;
        int n = 0;

        for (Atividade ativ : atividades) {
            switch (ativ) {
                case Prova p -> {
                    media += p.nota;
                    n++;
                }
                default -> {}
            }
        }

        media /= (n != 0 ? n : 1);
        return media;
    }

    static Map readDisc(BufferedReader reader) {
        Map dados = new HashMap();

        return dados;
    }

    public static void main(String[] args) throws IOException {
        final String banner = ":: Sistema de Gestão Acadêmico :: Disciplinas e Turmas";

        final String options = """
        
        1. Gerenciar disciplinas
        2. Calcular a média de uma disciplina
        3. Calcular a média de atividades
        4. Editar atividades
        
        5. Sair
        """;

        System.out.println(banner);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println(options);
            int chosenOption = readInteger(reader);

            int id;
            Disciplina disc = null;

            switch (chosenOption) {
                case MenuOption.GERENCIAR:
                    subOptionLoop: while (true) {
                        String suboptions = """

                        Escolha uma opção.

                        1. Adicionar disciplina
                        2. Editar disciplina
                        3. Excluir disciplina
                        """;

                        System.out.println(suboptions);
                        int chosenSubOption = readInteger(reader);
                    
                        switch (chosenSubOption) {
                            case CrudOption.ADICIONAR:
                                controller.criarDisciplina(readDisc(reader));
                                break subOptionLoop; 
                            case CrudOption.EDITAR:
                                System.out.println("Digite o ID da disciplina que você deseja editar:");
                                
                                do {
                                    id = readInteger(reader);
                                    disc = controller.visualizarDisciplina(id);
                                } while (disc != null);

                                controller.editarDisciplina(id, readDisc(reader));
                                System.out.println(msg.gerar(TipoMensagem.SUCESSO, "Os dados da disciplina foram alterados"));

                                break subOptionLoop;
                            case CrudOption.EXCLUIR:
                                System.out.println("Digite o ID da disciplina que você deseja remover:");

                                do {
                                    id = readInteger(reader);
                                    disc = controller.visualizarDisciplina(id);
                                } while (disc != null);

                                controller.removerDisciplina(id);
                                System.out.println(msg.gerar(TipoMensagem.SUCESSO, "Disciplina removida"));
                                
                                break subOptionLoop;
                            default:
                                System.out.println(msg.gerar(TipoMensagem.ERRO, "Opção inválida: %d".formatted(chosenSubOption)));
                                break;
                        }
                    }

                    break;
                case MenuOption.MEDIA_DISCIPLINA:
                    do {
                        id = readInteger(reader);
                        disc = controller.visualizarDisciplina(id);
                    } while (disc != null);

                    double media = mediaDisc(disc);
                    
                    msg.gerar(TipoMensagem.SUCESSO, "Média da disciplina: %lf".formatted(media));
                    break;
                case MenuOption.MEDIA_ATIVIDADES:
                    // XXX
                    break;
                case MenuOption.EDITAR_ATIVIDADES:
                    
                    break;
                case MenuOption.SAIR:
                    System.exit(0);
                default:
                    System.out.println(msg.gerar(TipoMensagem.ERRO, "Opção inválida: %d".formatted(chosenOption)));
                    break;
            }
        }
    }
}
