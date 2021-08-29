public class Aeroporto {

    private Estado local;
    private Aviao aviao;

    Aeroporto(Estado local){
        if(local == null){
            throw new IllegalArgumentException("ERRO! Local do aeroporto nulo.");
        }
        this.local = local;
    }

    public void setAviao(Aviao aviao) {
        if(aviao == null){
            throw new IllegalArgumentException("ERRO! Aviao informado na funcao 'setAviao' do aeroporto nulo.");
        }
        this.aviao = aviao;
    }

    boolean verificaPassagem(Passagem passagem){
        if(passagem == null){
            throw new IllegalArgumentException("ERRO! Passagem informada no aeroporto nula.");
        }
/*
        if(aviao.getLOTACAO_MAX() < aviao.getPassageiros().size()){
            return false;
        }
*/
        if(passagem.getCliente().getTesteCovid()){
            return false;
        }

        if(passagem.getCliente().getNaturalidade() == aviao.getDestino().getLocal().getPais()){
            return true;
        }

        if(passagem.getCliente().getPassaporte() != null) {
            if (passagem.getCliente().getPassaporte().getPaisAutorizado().contains(aviao.getDestino().getLocal().getPais())) {
                return true;
            }
        }
        return false;
    }

    public void embarcaPassageiro(Passagem passagem){
        if(verificaPassagem(passagem)){
            aviao.adicionaPassageiro(passagem.getCliente());
        }
    }

    public Estado getLocal() {
        return this.local;
    }
}
