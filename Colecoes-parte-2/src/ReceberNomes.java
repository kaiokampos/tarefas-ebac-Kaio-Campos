import java.util.Scanner;

public class ReceberNomes {
    private Scanner scanner;

    public ReceberNomes(){
        scanner = new Scanner(System.in);
    }

    public String lerNomeESexo(){
        System.out.println("Digite o NOME e SEXO, EX: Kaio-m, Samara-f");
        return scanner.nextLine();
    }

}
