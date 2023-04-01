package Aula3.extrator;

import Aula3.extrator.ExtratorDeConteudo;
import Aula3.extrator.ExtratorDeConteudoDaNasa;
import Aula3.extrator.ExtratorDeConteudoDoIMDB;

public enum API {

    IMDB_TOP_250_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
    IMDB_MOST_POPULAR_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json", new ExtratorDeConteudoDoIMDB()),
    IMDB_MOST_POPULAR_TVs("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtratorDeConteudoDaNasa());

//    IMDB_TOP_250_MOVIES("https://imdb-api.com/en/API/Top250Movies/k_x3pev8lm", new ExtratorDeConteudoDoIMDB()),
//    IMDB_TOP_SERIES("https://imdb-api.com/en/API/Top250TVs/k_x3pev8lm", new ExtratorDeConteudoDoIMDB()),

    private final String url;
    private final ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
