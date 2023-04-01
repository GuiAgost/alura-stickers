package Aula2;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class App {
    private static final String STAR_YELOW = "\u001b[m\u001B[33m★\u001b[m";
    private static final String TERRIBLE = "\u001b[m\u001B[33m\uD83D\uDC4E";

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;
            String url;

            // MENU
            System.out.println("*=========Escolha sua imDbAPI=========");
            System.out.println("1 - Top250Movies");
            System.out.println("2 - MostPopularMovies");
            System.out.println("3 - MostPopularTVs");
            opcao = input.nextInt();

            // FAZER UMA CONEXÃO HTTP E BUSCAR OS TOP 250 FILMES
            Properties key = new Properties();
            FileInputStream prop = new FileInputStream("./key.properties"); // Busca o arquivo
            key.load(prop); // Carrega o conteúdo

            // PEGA O CONTEÚDO CHAVE API
            url = switch (opcao) {
                case 1 -> key.getProperty("prop.urlTop250Movies") + key.getProperty("prop.keyTop250Movies");
                case 2 -> key.getProperty("prop.urlMostPopularMovies") + key.getProperty("prop.keyMostPopularMovies");
                case 3 -> key.getProperty("prop.urlMostPopularTVs") + key.getProperty("prop.keyMostPopularTVs");
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            };

            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            // EXTRAIR SÓ OS DADOS QUE INTERESSAM (TITULO, POSTER E CLASSIFICAÇÃO)
            Gson gson = new Gson();
            Movies movieList = gson.fromJson(body, Movies.class);
            List<Map<String, String>> listaDeFilmes = movieList.getItems();

            // GERA FIGURINHAS
            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

            // EXIBIR E MANIPULAR OS DADOS
            for (Map<String, String> filme : listaDeFilmes) {
                String urlImagem  = filme.get("image").replaceAll("(@+)(.*).jpg$","$1.jpg");
                String titulo = filme.get("title");
                String classificacao = filme.get("imDbRating");
                String linkImagem = filme.get("image");

                // PARA GERAR A IMAGEM FIGURINHA
                InputStream inputStream = new URL(urlImagem).openStream(); // A PARTIR DA URL DA IMAGEM

                System.out.println("\u001b[32;1m\u001b[4mTítulo:\u001b[m " + "\u001b[36;1m" + titulo + "\u001b[m");
                System.out.println("\u001b[37;1m\u001b[44mLink de imagem:\u001b[m " + linkImagem);

                // SE A CLASSIFICAÇÃO VAZIA, RETORNA 0.0F
                float numberStar = Float.parseFloat(classificacao.isEmpty() ? String.valueOf(0.0F) : classificacao);
                geradora.cria(inputStream, "saida/" + titulo + ".png", numberStar);

                // SE A NOTA FOR VAZIA
                if (classificacao.isEmpty()) {
                    System.out.println("\u001b[34m\u001b[1m\u001b[4mClassificação Geral: 0.0" + " \u001b[m\u001B[33m\u001b[m");
                    System.out.println(TERRIBLE);
                } else {
                    System.out.println("\u001b[34m\u001b[1m\u001b[4mClassificação Geral: " + classificacao + " \u001b[m\u001B[33m\u001b[m");
                    for (int i = 1; i <= Math.abs(numberStar); i++) {
                        System.out.print(STAR_YELOW);
                    }
                }
                System.out.println("\n\n======================================================\n");
            }
        }
    }
}
