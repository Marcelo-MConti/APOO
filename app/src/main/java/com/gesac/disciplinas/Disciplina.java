package com.gesac.disciplinas;

import java.util.List;

public class Disciplina {
    int id;
    String nome;
    int cargaHoraria;
    List<Atividade> atividades;

    // construtor da minha classe
    public Disciplina(int id, String nome, int cargaHoraria, List<Atividade> atividades){
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.atividades = atividades;
    }

    public void adicionarAtividade(Atividade a) {
        this.atividades.add(a);
    }

    public void removerAtividade(int id) {
        // pesquiso por todas as atividades
        // removo quando encontrar
        for(Atividade a : atividades){
            if(a.id == id) this.atividades.remove(a);
        }
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
