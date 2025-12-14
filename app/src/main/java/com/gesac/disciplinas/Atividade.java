package com.gesac.disciplinas;

import java.util.Date;

public class Atividade {
    private int id;
    private String titulo;
    private String descricao;
    private TipoAtividade tipo;
    private double nota;
    
    // XXX: fix this in the diagram 
    private Date dataEntrega;

    private StatusAtividade status;

    public double getNota() {
        return nota;
    }
}
