package br.com.westes.screenmatch.modelos;

public class Filme extends Titulo {

    private String diretor;

    public Filme(String nome) {
        super(nome);
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return String.format("Filme [ %s ] ( %d )", this.getNome(), this.getAnoDeLancamento());
    }


}