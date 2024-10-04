import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Acessos {
    String key = "Chave para acesso a API";

    public String baseDeTaxasUSD(){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/latest/USD");
        return acesso(endereco);
    }
    public String taxadeCambio(String moedaOriginal, String moedaConversao){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+
                moedaOriginal+"/"+
                moedaConversao);
        return acesso(endereco);
    }
    public String acesso (URI endereco){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel obter o endereço: "+e);
        }
    }
}
