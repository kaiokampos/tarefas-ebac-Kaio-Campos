import java.util.ArrayList;
import java.util.Arrays;

/**
 * Como é pedido nos dois exercicios que sejam separados por virgula, usei o mesmo metodo.
 */
public class ConverterNomes {
    public static ArrayList<String> converterParaArrayList(String nomesString){
        // Conversão da string para um ArrayList de Strings separados por virgula
        ArrayList<String> nomesArray = new ArrayList<>();
        for (String nome : nomesString.split(",")){
            nomesArray.add(nome.trim()); // trim, retira os espaços em branco
        }
        return nomesArray;
    }
}
