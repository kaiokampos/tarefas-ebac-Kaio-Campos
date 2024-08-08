package org.example;

import org.example.Pessoa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testFiltroMulheres() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Alice", 30, "F"));
        pessoas.add(new Pessoa("Bob", 25, "M"));
        pessoas.add(new Pessoa("Carol", 22, "F"));
        pessoas.add(new Pessoa("Dave", 40, "M"));

        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .toList();

        // Verifica se todas as pessoas na lista de mulheres têm o sexo "F"
        assertTrue(mulheres.stream().allMatch(p -> p.getSexo().equalsIgnoreCase("F")),
                "A lista contém somente mulheres.");
    }
}
