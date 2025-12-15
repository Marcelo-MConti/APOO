package com.gesac.disciplinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DisciplinaController {
    DisciplinaRepository repositorio = new DisciplinaRepository();
    Validador validador = new Validador();
    Mensagens mensagens = new Mensagens();

    int inc = 0;

    public void criarDisciplina(Map dados) {
        Disciplina d = new Disciplina();

        d.id = inc++;
        d.atividades = new ArrayList<Atividade>();
        d.nome = (String)dados.get("nome");
        d.cargaHoraria = (Integer)dados.get("cargaHoraria");

        // XXX
        repositorio.atualizar(d);
    }

    public void editarDisciplina(int id, Map dados) {
        Disciplina d = repositorio.buscarPorId(id);

        d.nome = (String)dados.get("nome");
        d.cargaHoraria = (Integer)dados.get("cargaHoraria");

        // XXX
        repositorio.atualizar(d);
    }

    public void removerDisciplina(int id) {
        repositorio.remover(id);
    }

    public Disciplina visualizarDisciplina(int id) {
        return repositorio.buscarPorId(id);
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
