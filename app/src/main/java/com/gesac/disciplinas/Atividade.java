package com.gesac.disciplinas;

import java.util.Date;

public abstract class Atividade {
    int id;
    String titulo;
    Date dataInicio;
    String descricao;
    StatusAtividade status;

    // construtor da minha classse
    public Atividade(int id, String titulo, Date dataInicio, String descricao, StatusAtividade status){
                        this.id = id;
                        this.titulo = titulo;
                        this.dataInicio = dataInicio;
                        this.descricao = descricao;
                        this.status = status;
    }
}
