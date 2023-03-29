import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo, Float classificacao) throws Exception{

        // LEITURA DA IMAGEM
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // CRIA UMA NOVA IMAGEM COM MEMÓRIA COM TRANSPARÊNCIA E TAMANHO NOVO
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        newImage(imagemOriginal, novaAltura, largura, novaImagem, classificacao);
        directory(nomeArquivo, novaImagem);
    }
    // COPIAR A IMAGEM ORIGINAL PRA NOVA IMAGEM (EM MEMÓRIA)
    private static void newImage(BufferedImage imagemOriginal, int novaAltura, int largura, BufferedImage novaImagem, Float classificacao) throws FontFormatException, IOException {
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        configureFont(novaAltura, largura, graphics, classificacao);
    }

    // CONFIGURA A FONTE E ESCREVE UMA PALAVRA NA NOVA IMAGEM
    private static void configureFont(int novaAltura, int largura, Graphics2D graphics, Float classificacao) throws FontFormatException, IOException {
        Font font = Font.createFont(Font.ROMAN_BASELINE, new File("fonts/ComicNeueSansID.ttf"))
                .deriveFont(Font.PLAIN, 80);
        graphics.setColor(Color.GREEN);
        graphics.setFont(font);

        String palavra = "";

        if (classificacao >= 9) {
            palavra = "TOPZERA";
        } else if (classificacao < 9) {
            palavra = "MUITO BOM";
        } else if (classificacao <= 7){
            palavra = "BOM";
        } else if(classificacao <=5) {
            palavra = "MUITO RUIM";
        }

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D tam = fontMetrics.getStringBounds(palavra, graphics);
        int larguraTexto = (int) tam.getWidth();

        int novaLargura = (largura - larguraTexto) / 2;
        graphics.drawString(palavra, novaLargura, novaAltura - 100);
    }

    // CRIA NOVO DIRETÓRIO E SALVA A IMAGEM
    private static void directory(String nomeArquivo, BufferedImage novaImagem) throws IOException {
        File directory = new File("saida/");
        if (directory.exists() || directory.mkdir()){
            ImageIO.write(novaImagem, "png", new File(nomeArquivo));
        }
    }
}