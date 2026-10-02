package br.com.westes.screenmatch.excecao;

public class ErroConversaoAnoException extends RuntimeException {
    private String mensagem;

    public ErroConversaoAnoException(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
