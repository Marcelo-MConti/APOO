package com.gesac.disciplinas;

import java.util.Date;
import java.util.List;

public class Trabalho extends Atividade {
    Date dataEntrega;
    int quantidadeExercicios;
    List<String> grupo;

    public Trabalho(int id, String titulo, Date dataInicio, String descricao, StatusAtividade status,
            Date dataEntrega, int quantidadeExercicios, List<String> grupo) {
        super(id, titulo, dataInicio, descricao, status);
        this.dataEntrega = dataEntrega;
        this.quantidadeExercicios = quantidadeExercicios;
        this.grupo = grupo;
    }
}
