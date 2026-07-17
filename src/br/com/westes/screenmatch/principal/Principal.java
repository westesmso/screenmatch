package br.com.westes.screenmatch.principal;

import br.com.westes.screenmatch.calculos.CalculadoraDeTempo;
import br.com.westes.screenmatch.calculos.FiltroRecomendacao;
import br.com.westes.screenmatch.modelos.Episodio;
import br.com.westes.screenmatch.modelos.Filme;
import br.com.westes.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        Filme outro = new Filme("John Wick");
        outro.setAnoDeLancamento(2014);
        outro.setDuracaoEmMinutos(101);
        outro.setIncluidoNoPlano(true);

        Serie serie = new Serie("La Casa de Papel");
        serie.setAnoDeLancamento(2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " +calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        Episodio ep =  new Episodio();
        ep.setNumero(1);
        ep.setSerie(serie);
        ep.setTotalVisualizacoes(300);

        filtro.filtra(ep);

        var filmeDoPaulo = new Filme("Dogville");
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.setAnoDeLancamento(2003);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes= new ArrayList<>();
        listaDeFilmes.add(favorito);
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(outro);
        System.out.println("Tamanho da lista de Filmes: " + listaDeFilmes.size());
        System.out.println("Lista de filmes: " +  listaDeFilmes);
        System.out.println("Primeiro filme: "+ listaDeFilmes.get(0).toString());
    }
}
