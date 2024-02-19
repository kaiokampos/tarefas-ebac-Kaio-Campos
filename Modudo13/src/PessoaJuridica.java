public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String nome, Integer idade, String cnpj){
        super(nome, idade);
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }


    String quebraLinha = System.getProperty("line.separator");
    @Override
    public String toString() {
        return "PessoaJuridica{ " +
                "nome da empresa: " + getNome() + quebraLinha+
                "idade da empresa: "+getIdade()+" anos" +quebraLinha+
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
