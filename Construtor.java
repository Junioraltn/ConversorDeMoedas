import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Construtor {

    public int introducao(int modo, Scanner ler) throws IOException {
        while (true) {
            System.out.println("Qual modalidade de Conversão deseja Utilizar?");
            System.out.println("1) Just in Time - Consulta direta a taxa de câmbio mais recente, mas pode demorar!" +
                    "2) Real Time - Realiza a conversão imediata através da ultima atualização feita!"+
                    "3) Ver Histórico de Pesquisa");
            System.out.println("1, 2 ou 3?");
            modo = ler.nextInt();
            if (modo == 1 || modo == 2){
                break;
            }
            if (modo == 3){
                System.out.println("=============================================================");
                File file = new File("src/historico.txt");
                FileReader reader = new FileReader(file);
                int data = reader.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = reader.read();
                }
                reader.close();
                System.out.println("=============================================================");
            }

        }
        return modo;
    }
    public void CriarMenu(){
        System.out.println(
                "1) Dólar [USD];\n"+
                "2) Real [BRL];\n"+
                "3) Peso Argentino [ARS];\n"+
                "4) Peso Colombiano [COP];\n"+
                "5) Euro [EUR];\n"+
                "6) Peso chileno [CLP];\n");
    }
    public void opcoes(){
        System.out.println("Para selecionar a moeda, ou digite o número correspondente, exemplo: 3\n" +
                "               ou o nome da moeda, exemplo: Peso Argentino\n" +
                "               ou seu código de identificação, exemplo: BRL\n");

    }
    public TaxasDeConversao baseConversao(String json){
        try {
            Gson gson = new GsonBuilder().create();
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonObject conversionRatesJson = jsonObject.getAsJsonObject("conversion_rates");
            // Converte o objeto JsonObject para string JSON
            String taxas = conversionRatesJson.toString();

            // Converte a string JSON para uma instância de TaxasDeConversao
            return gson.fromJson(taxas, TaxasDeConversao.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel converter o Jason: "+e);
        }
    }
    public void historico(String cotacao) throws IOException {
        File file = new File("src/historico.txt");
        FileWriter writer = new FileWriter(file,true);
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        writer.write(localDateTime+" : "+cotacao+"\n");
        writer.close();
    }

}
/*

Currency Code	Currency Name		    Country
    ARS		    Argentine Peso		    Argentina
    BRL		    Brazilian Real		    Brazil
    CLP         Peso chileno            Chile
    COP	    	Colombian Peso		    Colombia
    EUR 		Euro			        European Union
    USD 		United States Dollar	United States
 */