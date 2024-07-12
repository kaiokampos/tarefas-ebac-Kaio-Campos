import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        // Obtendo a anotação da classe
        if (MinhaClasse.class.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = MinhaClasse.class.getAnnotation(Tabela.class);
            System.out.println("Nome da Tabela: " + tabela.value());
        } else {
            System.out.println("A anotação @Tabela não está presente na classe.");
        }
    }
}