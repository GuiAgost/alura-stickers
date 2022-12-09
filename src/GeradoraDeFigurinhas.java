import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception{

    // LEITURA DA IMAGEM
    BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

    // CRIA UMA NOVA IMAGEM COM MEMÓRIA COM TRANSPARÊNCIA E TAMANHO NOVO
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // COPIAR A IMAGEM ORIGINAL PRA NOVA IMAGEM (EM MEMÓRIA)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // ESCREVER UMA FRASE NA NOVA IMAGEM
    // PAREI NO 00:30:48!!!!!

    // ESCREVER A NOVA IMAGEM EM UM ARQUIVO
    ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));


    }

    public static void main(String[] args) throws Exception {
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}