import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final String STAR_YELOW = "\u001b[m\u001B[33m\u2605\u001b[m";
    private static final String TERRIBLE = "\u001b[m\u001B[33m\ud83c\udd96";

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;
            String url;

            // MENU OPÇÃO
            System.out.println("*=========Escolha sua imDbAPI=========");
            System.out.println("1 - Top250Movies");
            System.out.println("2 - MostPopularMovies");
            System.out.println("3 - MostPopularTVs");
            opcao = input.nextInt();

            // FAZ CONEXÃO E BUSCA OS DADOS GSON
            ImDbAPI imDbAPI = new ImDbAPI();
            url = switch (opcao) {
                case 1 -> imDbAPI.Top250Movies();
                case 2 -> imDbAPI.MostPopularMovies();
                case 3 -> imDbAPI.MostPopularTVs();
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            };

            // EXTRAI OS DADOS GSON
            List<Map<String, String>> listFilms = ExtractorImDbAPI.getFilms(url);

            // EXIBIR E MANIPULAR OS DADOS
            var geradora = new GeradoraDeFigurinhas();
            for (Map<String, String> films : listFilms) {

                String urlImagem = films.get("image");
                String titulo = films.get("title");
                String classificacao = films.get("imDbRating");

                // PARA GERAR A IMAGEM FIGURINHA
                InputStream inputStream = new URL(urlImagem).openStream(); // A PARTIR DA URL DA IMAGEM
                geradora.cria(inputStream, titulo + ".png");

                // EXIBE O TITULO, URL DA IMAGEM E A CLASSIFICAÇÃO
                System.out.println("\u001b[32;1m\u001b[4mTítulo:\u001b[m " + "\u001b[36;1m" + titulo + "\u001b[m");
                //System.out.println("\u001b[34;1m\u001b[4mImagem:\u001b[m " + urlImagem);

                float numberStar;
                // SE A NOTA FOR VAZIA
                if (films.get("imDbRating").isEmpty()) {
                    System.out.println("\u001b[30m\u001b[1m\u001b[4mClassificação Geral: 0.0" + " \u001b[m\u001B[33m\u001b[m");
                    System.out.print(TERRIBLE);
                } else {
                    System.out.println("\u001b[30m\u001b[1m\u001b[4mClassificação Geral: " + classificacao + " \u001b[m\u001B[33m\u001b[m");

                    numberStar = (float) Double.parseDouble(classificacao);
                    for (int i = 1; i <= Math.abs(numberStar); i++) {
                        System.out.print(STAR_YELOW);
                    }
                }
                System.out.println("\n\n======================================================\n");
            }
        }
    }
}