import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final String STAR_YELOW = "\u001b[m\u001B[33m\u2605\u001b[m";
    private static final String TERRIBLE = "\u001b[m\u001B[33m\uD83D\uDC4E";

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;
            String url;

            System.out.println("*=========Escolha sua imDbAPI=========");
            System.out.println("1 - Top250Movies");
            System.out.println("2 - MostPopularMovies");
            System.out.println("3 - MostPopularTVs");
            System.out.println("4 - Nasa Imagem");
            opcao = input.nextInt();

            // FAZ CONEXÃO E BUSCA OS DADOS GSON
            ContentAPI contentUrl = new ContentAPI();
            url = switch (opcao) {
                case 1 -> contentUrl.Top250Movies();
                case 2 -> contentUrl.MostPopularMovies();
                case 3 -> contentUrl.MostPopularTVs();
                case 4 -> contentUrl.UrlNasa();
                default -> throw new IllegalStateException("Unexpected value: " + opcao);
            };

            // EXTRAI OS DADOS GSON IMDB
            List<Map<String, String>> listDeConteudo = CLienteHttp.getContents(url);

            // EXTRAI OS DADOS GSON NASA
            //List<Conteudo> listDeConteudo = ExtractorNasa.extraiConteudos(url);

            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

            // EXIBIR E MANIPULAR OS DADOS
            for (Map<String, String> conteudo : listDeConteudo) { // Caso queira pegar todos os filmes
            //for (int i=0; i < 10; i++) {
                //Map<String, String> conteudo = listDeConteudo.get(i);

                String urlImagem = conteudo.get("image");
                //String urlImagem  = conteudo.get("image").substring(0,116) + ".jpg";
                //String urlImagem  = conteudo.get("image").replaceAll("(@+)(.*).jpg$","$1.jpg");
                String titulo = conteudo.get("title");
                String classificacao = conteudo.get("imDbRating");

                // PARA GERAR A IMAGEM FIGURINHA
                InputStream inputStream = new URL(urlImagem).openStream(); // A PARTIR DA URL DA IMAGEM
                geradora.cria(inputStream, "saida/" + titulo + ".png");

                // EXIBE O TITULO, URL DA IMAGEM E A CLASSIFICAÇÃO
                System.out.println("\u001b[32;1m\u001b[4mTítulo:\u001b[m " + "\u001b[36;1m" + titulo + "\u001b[m");
                //System.out.println("\u001b[34;1m\u001b[4mImagem:\u001b[m " + urlImagem);

                // SE A CLASSIFICAÇÃO VAZIA, RETORNA 0.0F, PARA NÃO CAUSAR EXCEPTION
                float numberStar = Float.parseFloat(classificacao.isEmpty() ? String.valueOf(0.0F) : classificacao);

                // SE A NOTA FOR VAZIA
                if (conteudo.get("imDbRating").isEmpty()) {
                    System.out.println("\u001b[30m\u001b[1m\u001b[4mClassificação Geral: 0.0" + " \u001b[m\u001B[33m\u001b[m");
                    System.out.println(TERRIBLE);
                } else {
                    System.out.println("\u001b[30m\u001b[1m\u001b[4mClassificação Geral: " + classificacao + " \u001b[m\u001B[33m\u001b[m");
                    for (int i = 1; i <= Math.abs(numberStar); i++) {
                        System.out.print(STAR_YELOW);
                    }
                }
                System.out.println("\n\n======================================================\n");
            }
        }
    }
}