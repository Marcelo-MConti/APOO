package com.gesac.disciplinas;

import java.util.List;
import java.util.Map;

public class DisciplinaController {
    DisciplinaRepository repositorio = new DisciplinaRepository();
    Validador validador = new Validador();
    Mensagens mensagens = new Mensagens();

    public void criarDisciplina(Map dados) {
        throw new UnsupportedOperationException();
    }

    public void editarDisciplina(int id, Map dados) {
        throw new UnsupportedOperationException();
    }

    public void removerDisciplina(int id) {
        throw new UnsupportedOperationException();
    }

    public Disciplina visualizarDisciplina(int id) {
        throw new UnsupportedOperationException();
    }

    public List<Atividade> checarAtividadesPendentes() {
        throw new UnsupportedOperationException();
    }

    public void adicionarAtividade(int idDisciplina, int idAtividade, Map dados) {
        throw new UnsupportedOperationException();
    }

    public void editarAtividade(int idDisciplina, int idAtividade, Map dados) {
        throw new UnsupportedOperationException();
    }

    public void removerAtividade(int idDisciplina, int idAtividade) {
        throw new UnsupportedOperationException();
    }
}
