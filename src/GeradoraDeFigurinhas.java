import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        // LEITURA DA IMAGEM
        //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg")); // NESSE CASO, CRIAR A PASTA "ENTRADA" QUE CONTENHA IMAGEM
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream(); // A PARTIR DA URL DA IMAGEM
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // CRIA UMA NOVA IMAGEM COM MEMÓRIA COM TRANSPARÊNCIA E TAMANHO NOVO
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // COPIAR A IMAGEM ORIGINAL PRA NOVA IMAGEM (EM MEMÓRIA)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // CONFIGURAR FONTE
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setColor(Color.GREEN);
        graphics.setFont(font);

        // ESCREVER UMA FRASE NA NOVA IMAGEM
        graphics.drawString("TOPZERA", 200, novaAltura - 80);

        // ESCREVER A NOVA IMAGEM EM UM ARQUIVO
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}

// https://unicode.org/emoji/charts/full-emoji-list.html