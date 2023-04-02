package Aula4;

import Aula4.client.ClienteHttp;
import Aula4.extrator.API;
import Aula4.extrator.Conteudo;
import Aula4.extrator.ExtratorDeConteudo;
import Aula4.generate.GeradoraDeFigurinhas;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            int opcao;
            API api;

            // MENU
            System.out.println("*=========API de linguagens=========");
            api = API.LINGUAGEM;

            String url = api.getUrl();
            ExtratorDeConteudo extrator = api.getExtrator();

            var http = new ClienteHttp();
            String json = http.buscaDados(url);

            // exibir e manipular os dados
            List<Conteudo> conteudos = extrator.extraiConteudos(json);

            var geradora = new GeradoraDeFigurinhas();

            for (int i = 0; i < 3; i++) {

                Conteudo conteudo = conteudos.get(i);
                String nomeArquivo = conteudo.titulo();
                String titulo = nomeArquivo.replace(":", "-");

                InputStream inputStream = new URL(conteudo.urlImagem()).openStream();

                geradora.cria(inputStream, "saida/" + titulo + ".png");

                System.out.println(titulo);
                System.out.println();
            }
        }
    }
}
