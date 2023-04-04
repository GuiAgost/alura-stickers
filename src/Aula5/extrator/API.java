package Aula5.extrator;

public enum API {

    LINGUAGEM("http://localhost:8080/linguagens", new ExtratorDeConteudoDaLinguagem());

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
