package com.kaiodeve;

import java.util.Scanner;

public class ControleDeFluxo {
    public static void main(String[] args) {
        System.out.println("Para calcular a média entre com 4 notas separadas por espaço ou uma nota por linha.");
        Scanner scanner = new Scanner(System.in);
        
//        Double nota1 = scanner.nextDouble();
//        Double nota2 = scanner.nextDouble();
//        Double nota3 = scanner.nextDouble();
//        Double nota4 = scanner.nextDouble();
        double nota = 0;
        for (int i = 1; i <= 4; i++){
            System.out.println("Digite a "+i+" nota do Aluno");
            nota += scanner.nextDouble();
        }

        Double media = ((nota) / 4);

        if (media > 7){
            System.out.println("A média do aluno foi: " + media + " e ele está aprovado");
        } else if (media >= 5) {
            System.out.println("A média do aluno foi: " + media + " e ele está de recuperação");
        }else {
            System.out.println("A média do aluno foi: " + media + " e ele está reprovado");
        }


    }
}
