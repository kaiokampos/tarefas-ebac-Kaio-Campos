import java.util.Locale;

interface ManipuladorString{
    String manipular(String string);
}
public class Main {
    public static void main(String[] args) {

        ManipuladorString maiuscula = new ManipuladorString() {
            @Override
            public String manipular(String string) {
                return string.toUpperCase(Locale.ROOT);

            }
        };

        System.out.println("Manipulação de string sem lambda "+ maiuscula.manipular("Kaio"));

        ManipuladorString maiusculaFl = string -> string.toUpperCase(Locale.ROOT);
        System.out.println("Manipulação com Lambda " + maiusculaFl.manipular("kaio com lambdar"));

    }
}
