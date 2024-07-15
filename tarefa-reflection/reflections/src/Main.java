public class Main {
    public static void main(String[] args) {
        // Obter a calsse anotada
        Class<MinhaClasse> myClass = MinhaClasse.class;

        // Obtendo a anotação da classe
        if (myClass.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = myClass.getAnnotation(Tabela.class);
            System.out.println("Nome da Tabela: " + tabela.name());
        } else {
            System.out.println("A anotação @Tabela não está presente na classe.");
        }
    }
}