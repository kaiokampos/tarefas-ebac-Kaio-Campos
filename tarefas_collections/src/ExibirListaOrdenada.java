import java.util.ArrayList;
/**
 * Esse exercicios foi muito mais fácil fazer tudo em um único arquivo (main), porém me propus a criar classes separadas
 * para "reaproveitar" e diminuir o tamanho do main, tentei fazer com as boas práticas, aceito dicas e sugestões....
 * Acredito que não valeu por o scanner em uma classe, talvez seja mais simples deixar o receber no próprio main...
 */
public class ExibirListaOrdenada {
    public static void main(String[] args) {
        ReceberNomes receberNomes = new ReceberNomes();
        String nomesString = receberNomes.lerNomes();

        ConverterNomes converterNomes = new ConverterNomes();
        ArrayList<String> nomesArayList = converterNomes.converterParaArrayList(nomesString);

        OrdenarNomes ordenarNomes = new OrdenarNomes();
        ordenarNomes.ordenar(nomesArayList);

        // Exibição dos nomes ordenados
        System.out.println("Nomes em ordem alfabética: ");
        for (String nome : nomesArayList) {
            System.out.println(nome);
        }
    }
}
