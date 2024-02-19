public class Programa {
    public static void main(String[] args) {

        PessoaFisica pessoaFisica = new PessoaFisica("Kaio", 36, "123.456.789-00");
        PessoaJuridica pessoaJuridica = new PessoaJuridica("MinhaEmpresa", 15, "12.345.678/0001-0");

        System.out.println(pessoaFisica);
        System.out.println(pessoaJuridica);
    }
}