package br.com.westes.screenmatch.modelos;

import br.com.westes.screenmatch.excecao.ErroConversaoAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulo(String nome) {
        this.nome = nome;
    }

    public Titulo(TituloOmdb dto) {
        this.nome = dto.title();
        if (dto.year().length() >4 ){
            throw new ErroConversaoAnoException("não consegui converter o ano porque tem mais de 4 dígitos");
        }
        this.anoDeLancamento = Integer.valueOf(dto.year());
        this.duracaoEmMinutos = Integer.valueOf(dto.runtime().substring(0,2));
    }

//    public void exibeFichaTecnica() {
//        System.out.println("Nome do filme: " + nome);
//        System.out.println("Ano de lançamento: " + anoDeLancamento);
//        System.out.println("Duração em minutos: " + duracaoEmMinutos);
//        System.out.println("Incluído no plano: " + incluidoNoPlano);
//    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "(nome='" + nome + '\''
                + " | anoDeLancamento='" + anoDeLancamento + '\''
                + " | duracaoEmMinutos='" + duracaoEmMinutos + '\'' + ")";
    }
}