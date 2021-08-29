public class Cliente extends Pessoa{
    private Passaporte passaporte;
    private Passagem passagem;

    Cliente(String nome, Pais naturalidade, Passagem passagem){
        super(nome, naturalidade);

        if(passagem == null){
            throw new IllegalArgumentException("ERRO! Passagem do cliente nula.");
        }

        this.passagem = passagem;
        this.passagem.setCliente(this);
    }

    public Passagem getPassagem() {
        return this.passagem;
    }

    public void setPassaporte(Passaporte passaporte) {
        if(passaporte == null){
            throw new IllegalArgumentException("ERRO! Passaporte informado na funcao 'setPassaporte' do cliente nulo.");
        }
        this.passaporte = passaporte;
    }

    public Passaporte getPassaporte() {
        return this.passaporte;
    }


}
