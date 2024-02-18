import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SepararNomesDoSexo {
    Map<String, List<String>> separar(ArrayList<String> nomeArray){
        Map<String, List<String>> nomesSeparados = new HashMap<>();

        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        for (String nomeESexo : nomeArray){
            String[] partes = nomeESexo.split("-");

            String nome = partes[0];
            String sexo = partes[1];

            if (sexo.equalsIgnoreCase("m")){
                masculinos.add(nome);
            } else if (sexo.equalsIgnoreCase("f")) {
                femininos.add(nome);
            }
        }

        nomesSeparados.put("masculinos", masculinos);
        nomesSeparados.put("femininos", femininos);

        return nomesSeparados;
    }
}
