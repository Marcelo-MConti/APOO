package com.gesac.disciplinas;

enum TipoMensagem {
    SUCESSO,
    ERRO
}

public class Mensagens {
    public String gerar(TipoMensagem tipo, String msg) {
        switch (tipo) {
            case TipoMensagem.ERRO:
                return "!! ERRO: %s".formatted(msg);
            case TipoMensagem.SUCESSO:
                return "## %s".formatted(msg);
            default:
                throw new IllegalArgumentException();
        }
    }
}
