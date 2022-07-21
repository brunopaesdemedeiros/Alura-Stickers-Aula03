import java.io.InputStream;
import java.net.URL;
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {                
       
       //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
       //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        
       String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
       ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);       

        // exibir e manupular os dados
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        for (int i = 0; i < 3; i++) {            
        
            Conteudo conteudo = conteudos.get(i); 
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";            
            
            var geradorDeFigurinhas = new GeradorDeFigurinhas();            
            geradorDeFigurinhas.gerarFigurinha(inputStream, nomeArquivo);
                       
            //Float rating = Float.parseFloat(filme.get("imDbRating"));

            System.out.println(conteudo.getTitulo());
            System.out.println();

            /*String estrela = "";
            for (int i = 0; i <= rating; i++) {
               estrela = estrela +"\u2B50"; 
            }       
            System.out.println("\u001b[48;2;228;2;2m\u001b[1mNota: \u001b[m\u001b[48;2;228;2;2m" + rating + " \u001b[m");
            System.out.println(estrela+"\n");
            System.out.println("\u001b[255,255,255m Título: \u001b[0m" + titulo);
            System.out.println("Poster: " + poster);
            System.out.println();*/
        }
    }
       
    }

