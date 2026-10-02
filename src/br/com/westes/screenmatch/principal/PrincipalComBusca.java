package br.com.westes.screenmatch.principal;

import br.com.westes.screenmatch.excecao.ErroConversaoAnoException;
import br.com.westes.screenmatch.modelos.Titulo;
import br.com.westes.screenmatch.modelos.TituloOmdb;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String search = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para a busca: ");
            search = input.nextLine();
            if (search.equalsIgnoreCase("sair")) {
                break;
            }

            search = search.toLowerCase();
            search = search.replace(' ', '+');

            String url = "https://www.omdbapi.com/?t=" + search + "&apikey=652215c3";
            System.out.println(url);
            try {

                HttpResponse<String> response;
                try (HttpClient client = HttpClient.newHttpClient()) {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();
                    response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());
                }

                System.out.println(response.body());
                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo titulo = null;
                titulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido:");
                System.out.println(titulo);

                titulos.add(titulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro ao converter objeto.");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroConversaoAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titulos));
        writer.close();

        System.out.println("programa encerrado com sucesso");
    }
}