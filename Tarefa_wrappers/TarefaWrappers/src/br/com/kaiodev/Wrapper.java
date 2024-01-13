package br.com.kaiodev;

import java.util.Scanner;

public class Wrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero inteiro");

        int numero = scanner.nextInt();

        Integer numeroWrapper = Integer.valueOf(numero);

        System.out.println("Numero Primitivo: " + numero);


        System.out.println("Numero Wrapper: " + numeroWrapper);


    }
}
