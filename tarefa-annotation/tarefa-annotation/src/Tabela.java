import java.lang.annotation.*;

// Definindo a anotação @Tabela
@Retention(RetentionPolicy.RUNTIME)  // A anotação estará disponível em tempo de execução
@Target(ElementType.TYPE)  // A anotação pode ser usada em classes ou interfaces
@Documented // A anotação está documentada
public @interface Tabela {
    String value();  // Definindo um elemento que armazenará o nome da tabela
}
