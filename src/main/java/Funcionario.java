public class Funcionario extends Pessoa{
    private String funcao;

    Funcionario(String nome, Pais naturalidade, String funcao){
        super(nome, naturalidade);

        if(funcao == null){
            throw new IllegalArgumentException("ERRO! Funcao do funcionario nulo.");
        }

        this.funcao = funcao;
    }

    public String getFuncao() {
        return this.funcao;
    }
}
