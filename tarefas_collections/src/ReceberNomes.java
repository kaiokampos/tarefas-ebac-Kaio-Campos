import java.util.Scanner;

public class ReceberNomes {
    private final Scanner scanner;

    public ReceberNomes() {
        scanner = new Scanner(System.in);
    }

    public String lerNomes() {
        System.out.println("Digite os nomes separados por vírgula: ");
        return scanner.nextLine();
    }
    public String lerNomeESexo() {
        System.out.println("Digite os nomes e sexo, exemplo: Kaio-m, Samara-f");
        return scanner.nextLine();
    }
}
