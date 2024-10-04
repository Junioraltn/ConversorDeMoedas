import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxasDeConversao {
    private double USD;
    private double BRL;
    private double ARS;
    private double COP;
    private double EUR;
    private double CLP;

    public double getTaxaMoeda(String moedaOriginal, String moedaConversao){
        List<String> listMoeda = Arrays.asList(moedaOriginal,moedaConversao);
        List<Double> listaTaxas = new ArrayList<>();
        String moeda;

        for (int i=0;i<2;i++){
            moeda = listMoeda.get(i);
            switch (moeda){
                case "USD":
                    listaTaxas.add(i,this.USD);
                    break;
                case "BRL":
                    listaTaxas.add(i,this.BRL);
                    break;
                case "ARS":
                    listaTaxas.add(i,this.ARS);
                    break;
                case "COP":
                    listaTaxas.add(i,this.COP);
                    break;
                case "EUR":
                    listaTaxas.add(i,this.EUR);
                    break;
                case "CLP":
                    listaTaxas.add(i,this.CLP);
                    break;
            }
        }
        return listaTaxas.getLast()/listaTaxas.getFirst();
    }
    public double taxadeCambio(String json){
        try {
            Gson gson = new Gson();
            Cambio cambioObj = gson.fromJson(json,Cambio.class);
            return cambioObj.conversion_rate();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel converter o Jason: "+e);
        }
    }
}
