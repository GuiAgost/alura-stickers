import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClienteHttp {

    public String Top250Movies() throws IOException{
        Properties key = getKey(); // Atribui o conteúdo
        return key.getProperty("prop.urlTop250Movies") + key.getProperty("prop.keyTop250Movies");
    }

    public String MostPopularMovies() throws IOException{
        Properties key = getKey(); // Atribui o conteúdo
        return key.getProperty("prop.urlMostPopularMovies") + key.getProperty("prop.keyMostPopularMovies");
    }

    public String MostPopularTVs() throws IOException{
        Properties key = getKey(); // Atribui o conteúdo
        return key.getProperty("prop.urlMostPopularTVs") + key.getProperty("prop.keyMostPopularTVs");
    }

    public String Nasa() throws IOException{
        Properties key = getKey(); // Atribui o conteúdo
        return key.getProperty("prop.urlNasa") + key.getProperty("prop.keyNasa") + key.getProperty("prop.dateNasa");
    }

    public Properties getKey() throws IOException {
        Properties key = new Properties(); // Instancia a classe Properties
        FileInputStream prop = new FileInputStream("./key.properties"); // Busca o arquivo
        key.load(prop); // Carrega o conteúdo
        return key;
    }
}