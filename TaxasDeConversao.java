import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

public class TaxasDeConversao {
    private Map<String, Double> taxasDasMoedas = new HashMap();

    public void setTaxasDasMoedas(Map<String, Double> taxasDasMoedas) {
        this.taxasDasMoedas = taxasDasMoedas;
    }

    public Map<String, Double> getTaxasDasMoedas() {
        return taxasDasMoedas;
    }
    public double getTaxaMoeda(String moedaOriginal, String moedaConversao){
        List<String> listMoeda = Arrays.asList(moedaOriginal,moedaConversao);
        List<Double> listaTaxas = new ArrayList<>();
        String moeda;

        for (int i=0;i<2;i++){
            moeda = listMoeda.get(i);
            for (String item : this.taxasDasMoedas.keySet()){
                if (moeda.equalsIgnoreCase(item)){
                    listaTaxas.add(this.taxasDasMoedas.get(item));
                    break;
                }
            }
        }
        if (listaTaxas.size()<2){
            System.out.println(listaTaxas);
            System.out.println("Moeda não encontrada!");
            return 0;
        }
        return listaTaxas.getLast()/listaTaxas.getFirst();
    }
    public double taxadeCambio(String json){
        try {
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel converter o Jason: "+e);
        }
    }
}