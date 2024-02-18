import java.util.*;

public class Exibir {
    public static void main(String[] args) {

        ReceberNomes receberNomes = new ReceberNomes();
        String nomeString = receberNomes.lerNomeESexo();

        ConverterNomes converterNomes = new ConverterNomes();
        ArrayList<String> nomesESexoArrayList = converterNomes.converterParaArrayList(nomeString);

        SepararNomesDoSexo separarNomesDoSexo = new SepararNomesDoSexo();
        Map<String, List<String>> nomesSeparados = separarNomesDoSexo.separar(nomesESexoArrayList);

        nomesSeparados.forEach((key, value) -> System.out.println(key + ":" + value));

        /**
         * Sei que não é um boa prática deixar esse tanto de comentários, porém como estou no inicio
         * to deixando para ir me adapantdo e vendo quais melhores opcoes de se fazer
         */


//        List<String> masculinos = nomesSeparados.get("masculinos");
//        List<String> femininos = nomesSeparados.get("femininos");
//
//        // Imprime os nomes masculinos
//        System.out.println("Nomes masculinos:");
//        for (String nome : masculinos) {
//            System.out.println(nome);
//        }
//
//        // Imprime os nomes femininos
//        System.out.println("Nomes femininos:");
//        for (String nome : femininos) {
//            System.out.println(nome);
//        }


        //        Scanner scanner = new Scanner(System.in);
//        System.out.println("Digite o NOME e SEXO, EX: Kaio-m, Samara-f");
//        String nomeString = scanner.nextLine();
//
//        ArrayList<String> nomesArray = new ArrayList<>();
//        for (String nome : nomeString.split(",")){
//            nomesArray.add(nome.trim());
//        }
//
////        for (int i = 0; i < nomesArray.size(); i++) {
////            System.out.println(nomesArray.get(i));
////
////        }
//
//        List<String> masculinos = new ArrayList<>();
//        List<String> femininos = new ArrayList<>();
//
//        Map<String, List<String>> nomesSeparados = new HashMap<>();
//
//        for (String nomeESexo : nomesArray){
//            String[] partes = nomeESexo.split("-");
//
//            String nome  = partes[0];
//            String sexo  = partes[1];
//
//            if (sexo.equalsIgnoreCase("m")){
//                masculinos.add(nome);
//            } else if (sexo.equalsIgnoreCase("f")) {
//                femininos.add(nome);
//            }
//        }
//        nomesSeparados.put("masculinos", masculinos);
//        nomesSeparados.put("femininos", femininos);
//
//        //System.out.println(nomesSeparados);
//        nomesSeparados.forEach((key, value) -> System.out.println(key + ":" + value));


    }
}