import java.io.IOException;
import java.util.*;

public class Principal {

    String[] moedasEscolhidas = new String[2];
    String[] simbolos = new String[2];
    String[] codigos = new String[2];
    Dados dados = new Dados();
    int posicao;

    public List escolherMoedas(boolean padrao, String entrada, Scanner ler,Construtor construtor,Set setMoedas){
        for (int i=0;i<2;i++){
            if (padrao){
                System.out.println("Escolha a moeda "+dados.getInteracao().get(i)+": ");
                entrada = ler.nextLine();
                posicao=-1;
                while (posicao == -1){
                    for(int j=0;j<3;j++){
                        for (int k=0;k<dados.getListDeList().get(j).size();k++){
                            if (entrada.equalsIgnoreCase((String) dados.getListDeList().get(j).get(k))){
                                posicao = k;
                                break;
                            }
                        }
                        if (posicao != -1) {
                            break;
                        }
                    }
                    if (posicao == -1){
                        construtor.opcoes();
                        construtor.CriarMenu();
                        System.out.println("Escolha a moeda "+dados.getInteracao().get(i)+": ");
                        entrada = ler.next();
                    }
                }
                moedasEscolhidas[i] = dados.getListaNomeMoedas().get(posicao);
                codigos[i] =dados.getListaCodigoMoedas().get(posicao);
                simbolos[i] =dados.getSimbolos().get(posicao);
            } else {

                System.out.println("Escolha a moeda "+dados.getInteracao().get(i)+": ");
                entrada = ler.nextLine();
                posicao=-1;
                while (posicao == -1){
                    for (int k=0;k<setMoedas.size();k++){
                        if (setMoedas.contains(entrada.toUpperCase())){
                            posicao = 0;
                            break;
                        }
                    }
                    if (posicao != -1) {
                        break;
                    }
                    if (posicao == -1){
                        System.out.println("Verifique se digitou corretamente!!");
                        if (entrada.length() != 3){
                            System.out.println("Digite o código da moeda, como \"USD\" ou \"BDT\"");
                        } else {
                            System.out.println("Esse código não foi localizado!");
                        }
                        System.out.println(setMoedas);
                        System.out.println("Escolha a moeda "+dados.getInteracao().get(i)+": ");
                        entrada = ler.next();
                    }
                }
                moedasEscolhidas[i] = entrada.toUpperCase();
                codigos[i] = entrada.toUpperCase();
                simbolos[i] = "";
            }
        }
        List<String[]> listasEscolha = Arrays.asList(moedasEscolhidas,codigos,simbolos);
        return listasEscolha;
    }
    public static void main(String[] args) throws IOException {

        Scanner ler = new Scanner(System.in);
        double valorConvertido;
        List<String[]> listas;
        double entradaValor;
        String entrada = "";
        double cambio = 0;

        Principal principal = new Principal();
        Acessos acesso = new Acessos();
        String json;
        Construtor construtor = new Construtor();
        TaxasDeConversao taxas = new TaxasDeConversao();
        int modo=0;
        boolean padrao=true;

        modo = construtor.introducao(modo, ler);//Mensagem de Introdução
        ler.nextLine();
        if (modo == 2){
            json = acesso.baseDeTaxasUSD();//Recebe os dados em json - Modo Real Time, é onde vem todas as taxas de cambio em função do dolar
            taxas.setTaxasDasMoedas(construtor.baseConversao(json));
            System.out.println("Estas são as Moedas definidas como Padão: ");
            construtor.CriarMenu();
            System.out.println("Deseja converter valores além das moedas disponiveis como padrão? (S / ...)");
            entrada = ler.nextLine();
            if (!entrada.toLowerCase().equals("s")){
                System.out.println("A Lista padrão de Moedas está disponível");
                padrao=true;
            } else {
                System.out.println("A lista ampliada de código de moedas está disponível!");
                padrao=false;
            }
        }
        System.out.println("Este é conversor de Moeda:"+
                "Selecione a moeda e insira o valor a ser convertido");

        while (true){
//======Momento de Escolha das Moedas para realizar a Conversão==============================
            if (padrao){
                construtor.CriarMenu();
            } else {
                System.out.println(taxas.getTaxasDasMoedas().keySet());
            }
            listas = principal.escolherMoedas(padrao,entrada, ler,construtor, taxas.getTaxasDasMoedas().keySet());
//===============================================================================================
            System.out.printf("Processo: %s >> %s\n",listas.get(0)[0],listas.get(0)[1]);

            switch (modo){
                case 1://           Conversão em JustTime
                    json = acesso.taxadeCambio(listas.get(1)[0], listas.get(1)[1]);
                    cambio = taxas.taxadeCambio(json);
                    break;
                case 2://           Conversão em RealTime
                    cambio = taxas.getTaxaMoeda(listas.get(1)[0],listas.get(1)[1]);
                    break;
            }

            System.out.println("Qual é o valor a ser convertido");
            entradaValor = ler.nextDouble();

            valorConvertido = cambio * entradaValor;

            System.out.printf("Taxa: %.3f - %s: %s %.2f >> %s: %s %.2f\n",cambio,listas.get(0)[0],listas.get(2)[0],entradaValor,listas.get(0)[1],listas.get(2)[1],valorConvertido);

            construtor.historico(("Taxa: "+cambio+" - "+listas.get(0)[0]+": "+listas.get(2)[0]+" "+entradaValor+" >> "+listas.get(0)[1]+": "+listas.get(2)[1]+" "+valorConvertido).toString());

            System.out.println("Deseja continuar (S / qualquer valor)?");
            ler.nextLine();
            entrada = ler.nextLine();

            if (!entrada.toLowerCase().equals("s")){
                System.out.println("Volte Sempre!!");
                break;
            }
        }
    }
}