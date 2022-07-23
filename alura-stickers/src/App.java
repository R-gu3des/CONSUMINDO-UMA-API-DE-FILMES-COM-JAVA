import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // ****Projeto crido clicando "ctrl + shift + p" e digitando criar projeto java e já aparece como primeira opção****
        

        // "Shift + alt + o" realiza todos os imports
        // 1 - Fazer conexão HTTP  e buscar os top filmes presentes em um link:
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var cliente = HttpClient.newHttpClient();  // HttpClient cliente = HttpClient.newHttpClient(); é possível declarar desta forma
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        var body = response.body();

        // Extrair dados mais interessantes (títulos, poster e classificação ):

        var parser = new jsonParser();
        List<Map<String, String>> listaFilmes = parser.parse(body); // Map é como o dicionario no pyhton (Possui chave valor) o "<String, String>"" se refere a chave e valor.


        // Exibir e manipular os dados:

        for (Map<String,String> filme : listaFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println(" ");
        }
    }
}
