public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, Integer idade, String cpf) {
        super(nome, idade);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return cpf;
    }

    String quebraLinha = System.getProperty("line.separator");
    @Override
    public String toString() {
        return "PessoaFisica{ " +
                "nome: "+getNome()+ quebraLinha +
                " idade: "+getIdade()+" anos "+quebraLinha+
                "cpf='" + cpf + '\'' +
                '}';
    }
}
