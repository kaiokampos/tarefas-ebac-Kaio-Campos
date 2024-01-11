package br.com.kaiodev;

/**
 * @author Kamysa
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Aluno");
        Aluno kaio = new Aluno();
        kaio.setId(001);
        kaio.setNome("kaio");
        kaio.setTurma("Turma 01");

        java.lang.String nome = kaio.getNome();
        java.lang.String turma = kaio.getTurma();
        System.out.println("Olá " + nome + " você deveria está na " + turma);


    }
}
