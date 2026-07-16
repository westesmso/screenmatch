package br.com.westes.screenmatch.calculos;

import br.com.westes.screenmatch.modelos.Titulo;

public class FiltroRecomendacao {

    public void filtra(Classificavel c){
        if (c.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos");
        } else if (c.getClassificacao() == 2 ) {
            System.out.println("Filme bem avaliado");
        } else {
            System.out.println("Coloque na sua lista para ver depois");
        }
    }
}
