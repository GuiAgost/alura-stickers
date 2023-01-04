import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorNasa {

    public List<Conteudo> extraiConteudos(String gson) throws IOException, InterruptedException {

        List<Map<String, String>> listDeConteudo = CLienteHttp.getContents(gson);
        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listDeConteudo) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
