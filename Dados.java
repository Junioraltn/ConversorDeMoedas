import java.util.Arrays;
import java.util.List;

public class Dados {
    private List<String> listaCodigoMoedas = Arrays.asList("USD","BRL","ARS", "COP", "EUR","CLP");
    private List<String> listaNomeMoedas = Arrays.asList("Dólar","Real","Peso Argentino","Peso Colombiano","Euro","Peso chileno");
    private List<String> listOpcoes = Arrays.asList("1","2","3","4","5","6");
    private List<String> simbolos = Arrays.asList("$","R$","$","$","€","$");
    private List<List> listDeList = Arrays.asList(listaCodigoMoedas,listaNomeMoedas,listOpcoes);
    private List<String> interacao = Arrays.asList("Base","de Destino");
    public List<String> getListaCodigoMoedas() {
        return listaCodigoMoedas;
    }
    public List<String> getListaNomeMoedas() {
        return listaNomeMoedas;
    }
    public List<String> getListOpcoes() {
        return listOpcoes;
    }
    public List<String> getInteracao() {
        return interacao;
    }
    public List<String> getSimbolos() {
        return simbolos;
    }
    public List<List> getListDeList() {
        return listDeList;
    }
}
