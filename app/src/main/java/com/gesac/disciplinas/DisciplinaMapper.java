package com.gesac.disciplinas;
import com.gesac.disciplinas.*;

// a ideia de ser uma classe que ajuda 
// no tratamento do arquivo em CSV
public class DisciplinaMapper {
    
    // INPUT: Linha do CSV do arquivo das Disciplinas
    // OUTPUT: Disciplina montada
    // linha do CSV:
    // id, nome, cargaHoraria
    public static Disciplina DiscFromCSV(String linha){
        String[] partes = linha.split(",");

        return new Disciplina(Integer.parseInt(partes[0]), // id
                              partes[1],                   // nome
                              Integer.parseInt(partes[2]), // Carga horaria
                              null);           // List<atividade>
    } 

    // INPUT:  Disciplina para ser colocar no CSV file
    // OUTPUT: String da Dsiciplina pronta para colocar no CSV file
    public static String DiscToCsv(Disciplina a){
        return Integer.toString(a.id) + "," + a.nome + "," + Integer.toString(a.cargaHoraria);
    }

    // INPUT:  Linha do CSV do arquivo das Atividades
    // Output: Atividade montada
    // Linha no CSV:
    // id, titulo, descrição, dataInicio, status
   
    public static Atividade AtivFromCSV(String linha){
        String[] partes = linha.split(",");

        return new Atividade(Integer.parseInt(partes[0]), // id
                  partes[1],                              // titulo
                  partes[2],                              // descrição
                  partes[3],                              // data inicio
                  partes[4]                               // status
        );
    }

    // INPUT:  Atividade para ser colocar no CSV file
    // OUTPUT: String da atividade pronta para colocar no CSV
    public static String AtivToCsv(Atividade a){
        return Integer.toString(a.id) + "," + a.titulo + "," + a.descricao + "," + a.dataInicio + "," + a.status;
    }
}
