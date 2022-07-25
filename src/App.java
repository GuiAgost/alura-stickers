import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
// Viedeo para emoticom: https://www.youtube.com/watch?v=D8uw2hefrB8
// https://en.wikipedia.org/wiki/ANSI_escape_code
// https://www.javatips.net/api/wire-android-master/wire-core/src/main/java/com/waz/zclient/utils/Emojis.java
// Conversão: https://r12a.github.io/app-conversion/
// https://www.alura.com.br/artigos/decorando-terminal-cores-emojis
// https://github.com/delight-im/Emoji/blob/master/Java/Source/src/im/delight/java/emoji/Emoji.java

public class App {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        float nota;
        int opcao;
        String url;

        System.out.println("*=========Escolha sua imDbAPI=========");
        System.out.println("1 - Top250Movies");
        System.out.println("2 - MostPopularMovies");
        System.out.println("3 - MostPopularTVs");
        opcao = input.nextInt();

        ImDbAPI imDbAPI = new ImDbAPI(); // Faz conexão e busca os dados gson

        url = switch (opcao) {
            case 1 -> imDbAPI.Top250Movies();
            case 2 -> imDbAPI.MostPopularMovies();
            case 3 -> imDbAPI.MostPopularTVs();
            default -> throw new IllegalStateException("Unexpected value: " + opcao);
        };

        Gson gson = new Gson();
        Movies movieList = gson.fromJson(ExtractorImDbAPI.getBody(url), Movies.class);
        List<Map<String, String>> listFilm = movieList.getItems();

        // EXIBIR E MANIPULAR OS DADOS
        // Quando der tempo, criar um enum ou interface para colorir.
        for (Map<String, String> films : listFilm) {
            System.out.println("\u001b[32;1m\u001b[4mTítulo:\u001b[m " + "\u001b[36;1m" +films.get("title") +"\u001b[m");
            System.out.println("\u001b[34;1m\u001b[4mImagem:\u001b[m " + films.get("image"));
            System.out.println("\u001b[30m\u001b[42;1m\u001b[4mClassificação Geral: " + films.get("imDbRating") + " \u001b[m\u001B[33m\u001b[m");

            float number = (float) Double.parseDouble(films.get("imDbRating"));
            for (int i = 1; i <= Math.abs(number); i++){
                System.out.print("\u001b[m\u001B[33m\u2605\u001b[m");
            }

            System.out.println("\nQue nota você dará esse filme?");
            nota = input.nextFloat();
            System.out.println("\u001b[30m\u001b[42;1m\u001b[4mSua nota: " + nota+ " \u001b[m\u001B[33m\u001b[m");
            for (int i = 1; i <= Math.abs(nota); i++){
                System.out.print("\u001b[m\u001B[33m\u2605\u001b[m");
            }
            System.out.println("\n\n======================================================\n");
        }
    }
}
