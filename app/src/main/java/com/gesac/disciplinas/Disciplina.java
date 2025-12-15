package com.gesac.disciplinas;

import java.util.List;

public class Disciplina {
    int id;
    String nome;
    int cargaHoraria;
    List<Atividade> atividades;

    public void adicionarAtividade(Atividade a) {
        throw new UnsupportedOperationException();
    }

    public void removerAtividade(int id) {
        throw new UnsupportedOperationException();
    }

    // How is this one going to work? 🤔 
    public void editarAtividade(Atividade a) {
        throw new UnsupportedOperationException();
    }
}
