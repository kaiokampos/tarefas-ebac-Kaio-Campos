import java.util.ArrayList;

public class ConverterNomes {
    public static ArrayList<String> converterParaArrayList(String nomesString){
        // Converte as strings de entrada para um ArrayList de strings separados por virgula
        ArrayList<String> nomesArray = new ArrayList<>();

        for (String nomeESexo : nomesString.split(",")){
            nomesArray.add(nomeESexo.trim());
        }
        return nomesArray;
    }
}
