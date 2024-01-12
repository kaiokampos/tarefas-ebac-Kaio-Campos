//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Digite as 4 notas do aluno, separadas por espaço");
        calcularMedia(4.5, 7.8, 9, 8.2);
    }
    static void calcularMedia(double n1, double n2, double n3, double n4){
        double media = (n1 + n2 + n3 + n4) / 4;
        System.out.println("A média do aluno é: "+ media);
    }
}