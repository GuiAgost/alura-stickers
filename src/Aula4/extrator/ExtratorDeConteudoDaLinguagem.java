package Aula4.extrator;

import Aula4.json.JsonParser;

import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaLinguagem implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
         // extrair só os dados que interessam (titulo, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> listaDeAtributos = parser.parse(json);

         return listaDeAtributos.stream()
         .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image")))
         .toList();
 
    }

}
