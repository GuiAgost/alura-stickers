import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ContentAPI {

    protected static List<Map<String, String>> getContents(String url) throws IOException, InterruptedException {
        Gson gson = new Gson();
        Movies conteudo = gson.fromJson(getBody(url), Movies.class);
        return conteudo.getItems();
    }

     protected static String getBody(String url) throws IOException, InterruptedException {
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
