package com.gesac.disciplinas;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class DisciplinaRepository {
    private HashMap<Integer, Disciplina> disciplinas;

    // fazer metodos auxiliares:
    private List<Disciplina> lerTodasDisc(){
        // usar FUNCIONAL, para ler do CSV e converter para Disciplina DiscFromCSV
        // ?
    }

    private void escreverTodasDisc(List<Disciplina> disciplinas) {
        // usar Funcional, DiscToCSV
        // ?
    }

    private List<Atividade> lerTodasAtiv(){
        // usar FUNCIONAL, para ler do CSV e converter para Ativ AtivFromCSV
        // ?
    }

    private void escreverTodasAtiv(List<Atividade> atividade) {
        // usar Funcional, AtivToCSV
        // ?
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
        List<Disciplina>disciplinas = lerTodasDisc();
        disciplinas.removeIf(d->d.id == id);
        escreverTodasDisc(disciplinas);
    }

    public Optional<Disciplina> buscarPorId(int id) {
        return lerTodasDisc().stream()
               .filter(d -> d.id == id)
               .findFirst();            
    }

    public List<Disciplina> listarTodas() {
        return lerTodasDisc();
    }
}
