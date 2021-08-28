public class Estado extends Pais{
    String nomeEstado;

    Estado(Pais pais, String nomeEstado){
        super(pais.nomePais);

        if(nomeEstado == null){
            throw new IllegalArgumentException("ERRO! Nome do estado nulo.");
        }
        this.nomeEstado = nomeEstado;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }

    @Override
    public String getNomePais() {
        return super.getNomePais();
    }
}
