package com.gesac.disciplinas;

enum TipoMensagem {
    SUCESSO,
    ERRO
}

public class Mensagem {
    private TipoMensagem tipo;
    private String conteudo;
    
    Mensagem(TipoMensagem tipo, String conteudo) {
        this.tipo = tipo;
        this.conteudo = conteudo;
    }
    
    @Override
    public String toString() {
        switch (tipo) {
            case TipoMensagem.ERRO:
                return "!! ERRO: %s".formatted(conteudo);
            case TipoMensagem.SUCESSO:
                return "## %s".formatted(conteudo);
            default:
                throw new IllegalArgumentException();
        }
    }
}
