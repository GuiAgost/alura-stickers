package Aula4;

import Aula4.client.ClienteHttp;
import Aula4.extrator.API;
import Aula4.extrator.Conteudo;
import Aula4.extrator.ExtratorDeConteudo;
import Aula4.generate.GeradoraDeFigurinhas;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;
            API api;

            // MENU
            System.out.println("*=========Escolha sua imDbAPI=========");
            System.out.println("1 - Top250Movies");
            System.out.println("2 - MostPopularMovies");
            System.out.println("3 - MostPopularTVs");
            System.out.println("4 - NASA");
            System.out.println("5 - Liguagem");
            opcao = input.nextInt();

            api = switch (opcao) {
                case 1 -> API.IMDB_TOP_250_MOVIES;
                case 2 -> API.IMDB_MOST_POPULAR_MOVIES;
                case 3 -> API.IMDB_MOST_POPULAR_TVs;
                case 4 -> API.NASA;
                case 5 -> API.LINGUAGEM;
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            };

            String url = api.getUrl();
            ExtratorDeConteudo extrator = api.getExtrator();

            var http = new ClienteHttp();
            String json = http.buscaDados(url);

            // exibir e manipular os dados
            List<Conteudo> conteudos = extrator.extraiConteudos(json);

            var geradora = new GeradoraDeFigurinhas();

            for (int i = 0; i < 3; i++) {

                Conteudo conteudo = conteudos.get(i);
                String titulo = conteudo.titulo();;

                InputStream inputStream = new URL(conteudo.urlImagem()).openStream();

                geradora.cria(inputStream, "saida/" + titulo + ".png");

                System.out.println(titulo);
                System.out.println();
            }
        }
    }
}
