import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudos(String json){
    //pegar só os dados que interessam(título, poster, classificação)
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);


    //criar uma lista vazia
    List<Conteudo> conteudos = new ArrayList<>();

    //popular a lista de conteúdos

    for (Map<String, String> atributos : listaDeAtributos) {

       String titulo = atributos.get("title");
       String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");;
       var conteudo = new Conteudo(titulo, urlImagem);

       conteudos.add(conteudo);
       
    }

    return conteudos;
    
   }
}
