package com.gesac.disciplinas;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    int id;
    String nome;
    int cargaHoraria;
    List<Atividade> atividades;

    public Disciplina() {
        this(0, "", 0, null);
    }

    // construtor da minha classe
    public Disciplina(int id, String nome, int cargaHoraria, List<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.atividades = atividades == null ? new ArrayList<>() : atividades;
    }

    public void adicionarAtividade(Atividade a) {
        this.atividades.add(a);
    }

    public void removerAtividade(int id) {
        // pesquiso por todas as atividades
        // removo quando encontrar
        this.atividades.removeIf(a -> a.id == id);
    }

    // Funcionalmento da atividade:
    // 1) INPUT, Atividade com alteração feita nela
    // 2) Encontrar, atividade desatualizada pelo ID
    // 3) Excluir, atividade desatualizada
    // 4) Escrever, nova atividade
    public void editarAtividade(Atividade a) {
        // remover a Atividade antiga
        removerAtividade(a.id);

        // adicionar nova atividade alterada
        adicionarAtividade(a);
    }
}
