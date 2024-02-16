import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Achei esse Exercicios mais dificil. pelo tipo  de retorno do nomeSeparado. mas ta fluindo..
 */
public class ExibirNomesSexo {
    public static void main(String[] args) {

        ReceberNomes receberNomes = new ReceberNomes();
        String nomeString = receberNomes.lerNomeESexo();

        ConverterNomes converterNomes = new ConverterNomes();
        ArrayList<String> nomesArrayList = converterNomes.converterParaArrayList(nomeString);

        SepararNomesPorSexo separador = new SepararNomesPorSexo();
        Map<String, List<String>> nomesSeparados = separador.separar(nomesArrayList);

        List<String> masculinos = nomesSeparados.get("masculinos");
        List<String> femininos = nomesSeparados.get("femininos");


        // Imprime os nomes masculinos
        System.out.println("Nomes masculinos:");
        for (String nome : masculinos) {
            System.out.println(nome);
        }

        // Imprime os nomes femininos
        System.out.println("Nomes femininos:");
        for (String nome : femininos) {
            System.out.println(nome);
        }
    }
}
