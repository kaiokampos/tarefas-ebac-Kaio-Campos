import java.util.*;
import java.util.stream.Collectors;

public class SepararNomesPorSexo {
    /**
     * Esta parte do código define um método chamado separar dentro da classe SeparadorNomes.
     * Sua função é receber uma lista de strings contendo nomes e sexos separados por hifem (ex: "João-m, Maria-f") e
     * retornar um map contendo duas listas separadas com os nomes masculinos e femininos.
     *
     * @return MAP
     */
    public Map<String, List<String>> separar(List<String> nomesSexos){
        Map<String, List<String>> nomesSeparados = new HashMap<>();

        // Lista para armazenar os nomes masculinos
        List<String> masculinos = new ArrayList<>();

        // Lista para armazenar os nomes femininos
        List<String> femininos = new ArrayList<>();

        for (String nomeSexo : nomesSexos) {
            // Divide cada parte em nome e sexo
            String[] partes = nomeSexo.split("-");

            String nome = partes[0];
            String sexo = partes[1];

            // Adiciona o nome à lista de acordo com o sexo
            if (sexo.equalsIgnoreCase("m")) {
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
