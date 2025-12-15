package com.gesac.disciplinas;

import java.util.Date;

public class Prova extends Atividade {
    Date dataRealizacao;
    float nota;

    public Prova(int id, String titulo, Date dataInicio, String descricao, StatusAtividade status, Date dataRealizacao,
            float nota) {
        super(id, titulo, dataInicio, descricao, status);
        this.dataRealizacao = dataRealizacao;
        this.nota = nota;
    }
}
