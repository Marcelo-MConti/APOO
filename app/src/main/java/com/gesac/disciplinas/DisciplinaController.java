package com.gesac.disciplinas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisciplinaController {
    DisciplinaRepository repository = new DisciplinaRepository();

    public Mensagem criarDisciplina(Disciplina d) {
        // XXX: ID?
        repository.salvar(d);
        return new Mensagem(TipoMensagem.SUCESSO, "Disciplina criada");
    }

    public Mensagem editarDisciplina(Disciplina d) {
        repository.atualizar(d);
        return new Mensagem(TipoMensagem.SUCESSO, "Os dados da disciplina foram alterados");
    }

    public Mensagem removerDisciplina(int id) {
        repository.remover(id);
        return new Mensagem(TipoMensagem.SUCESSO, "A disciplina foi removida");
    }

    public Disciplina visualizarDisciplina(int id) {
        return repository.buscarPorId(id);
    }

    public List<Atividade> checarAtividadesPendentes() {
        Date today = new Date();
        List<Disciplina> disciplinas = repository.listarTodas();

        List<Atividade> pendentes = new ArrayList<Atividade>();

        for (Disciplina disc : disciplinas) {
            if (disc.atividades == null)
                continue;
            for (Atividade ativ : disc.atividades) {
                boolean shouldAdd = ativ.dataInicio == null ? true : !ativ.dataInicio.after(today);

                if (ativ instanceof Prova) {
                    Prova p = (Prova) ativ;
                    if (p.dataRealizacao != null) {
                        shouldAdd = shouldAdd && !p.dataRealizacao.before(today);
                    }
                } else if (ativ instanceof Trabalho) {
                    Trabalho t = (Trabalho) ativ;
                    if (t.dataEntrega != null) {
                        shouldAdd = shouldAdd && !t.dataEntrega.before(today);
                    }
                }

                if (shouldAdd)
                    pendentes.add(ativ);
            }
        }

        return pendentes;
    }
}
