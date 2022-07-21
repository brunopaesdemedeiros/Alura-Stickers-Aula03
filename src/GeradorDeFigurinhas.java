import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void gerarFigurinha(InputStream inputStream, String nomeArquivo) throws Exception{

        /*leitura da imagem
        InputStream inputStream = new FileInputStream("Image/Filme_maior.jpg");
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();*/

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int alturaNova = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, alturaNova, BufferedImage.TRANSLUCENT);


        //copiar a imagem original para nova imagem(em memória)
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        //Configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64 );
        graphics.setColor(Color.blue);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imagem
        graphics.drawString("NÍVEL GOD!", 200, alturaNova - 80);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

   
}
