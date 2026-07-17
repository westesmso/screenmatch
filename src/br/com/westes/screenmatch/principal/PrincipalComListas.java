package br.com.westes.screenmatch.principal;

import br.com.westes.screenmatch.modelos.Episodio;
import br.com.westes.screenmatch.modelos.Filme;
import br.com.westes.screenmatch.modelos.Serie;
import br.com.westes.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix");
        Filme outro = new Filme("John Wick");
        Serie serie = new Serie("La Casa de Papel");
        var filmeDoPaulo = new Filme("Dogville");

        Episodio ep = new Episodio();
        ep.setNumero(1);
        ep.setSerie(serie);
        ep.setTotalVisualizacoes(300);

        List<Titulo> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(filmeDoPaulo);
        lista.add(outro);
        lista.add(serie);
        for (Titulo item : lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println("Diretor do filme: " + filme.getDiretor());
            }
        }
        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("John Wick");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("The Rock");
        buscaPorArtista.add("Jason Statan");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);

        System.out.println("Lista de Titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
    }
}
