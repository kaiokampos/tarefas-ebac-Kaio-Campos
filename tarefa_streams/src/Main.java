import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite a lista de pessoas (nome,idade,sexo(M ou F)) separados por vírgula e cada pessoa em uma nova linha. Pressione Enter duas vezes para finalizar:");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] parts = input.split(",");
            if (parts.length == 3) {
                try {
                    String nome = parts[0].trim();
                    int idade = Integer.parseInt(parts[1].trim());
                    String sexo = parts[2].trim();
                    pessoas.add(new Pessoa(nome, idade, sexo));
                } catch (NumberFormatException e) {
                    System.out.println("Idade inválida: " + parts[1].trim());
                }
            } else {
                System.out.println("Entrada inválida: " + input);
            }
        }

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        System.out.println("Lista de mulheres:");
        mulheres.forEach(System.out::println);

        scanner.close();
    }
}
