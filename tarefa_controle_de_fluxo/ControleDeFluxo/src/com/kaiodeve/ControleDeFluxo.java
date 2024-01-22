package com.kaiodeve;

import java.util.Scanner;

public class ControleDeFluxo {
    public static void main(String[] args) {
        System.out.println("Para calcular a média entre com 4 notas separadas por espaço");
        Scanner scanner = new Scanner(System.in);
        
        Double nota1 = scanner.nextDouble();
        Double nota2 = scanner.nextDouble();
        Double nota3 = scanner.nextDouble();
        Double nota4 = scanner.nextDouble();

        Double media = ((nota1 + nota2 + nota3 + nota4) / 4);

        if (media > 7){
            System.out.println("A média do aluno foi: " + media + " e ele está aprovado");
        } else if (media >= 5) {
            System.out.println("A média do aluno foi: " + media + " e ele está de recuperação");
        }else {
            System.out.println("A média do aluno foi: " + media + " e ele está reprovado");
        }


    }
}
