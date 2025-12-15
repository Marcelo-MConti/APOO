package com.gesac.disciplinas;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private final List<Disciplina> armazenamento = new ArrayList<>();

    // métodos auxiliares (in-memory)
    private List<Disciplina> lerTodasDisc() {
        return new ArrayList<>(armazenamento);
    }

    private void escreverTodasDisc(List<Disciplina> disciplinas) {
        armazenamento.clear();
        armazenamento.addAll(disciplinas);
    }

    private List<Atividade> lerTodasAtiv() {
        List<Atividade> atividades = new ArrayList<>();
        for (Disciplina d : armazenamento) {
            if (d.atividades != null)
                atividades.addAll(d.atividades);
        }
        return atividades;
    }

    private void escreverTodasAtiv(List<Atividade> atividade) {
        // sem persistência implementada para atividades separadamente.
    }

    public void salvar(Disciplina d) {
        List<Disciplina> disciplinas = lerTodasDisc();
        disciplinas.add(d);
        escreverTodasDisc(disciplinas);
    }

    public void atualizar(Disciplina d) {
        List<Disciplina> disciplina = lerTodasDisc();
        disciplina.replaceAll(x -> x.id == d.id ? d : x);
        escreverTodasDisc(disciplina);
    }

    public void remover(int id) {
        List<Disciplina> disciplinas = lerTodasDisc();
        disciplinas.removeIf(d -> d.id == id);
        escreverTodasDisc(disciplinas);
    }

    public Disciplina buscarPorId(int id) {
        return lerTodasDisc().stream()
                .filter(d -> d.id == id)
                .findFirst().orElse(null);
    }

    public List<Disciplina> listarTodas() {
        return lerTodasDisc();
    }
}
