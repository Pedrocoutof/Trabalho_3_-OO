import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private Aeroporto partida;
    private Aeroporto destino;
    private Funcionario piloto;
    private List<Cliente> passageiros;
    private IntegridadeAviao integridadeAviao;

    Aviao(Aeroporto partida, Aeroporto destino, Funcionario piloto){
        if (partida == null) {
            throw new IllegalArgumentException("ERRO! Partida do aviao nula.");
        }
        if (destino == null) {
            throw new IllegalArgumentException("ERRO! Destino do aviao nulo.");
        }
        if (piloto == null) {
            throw new IllegalArgumentException("ERRO! Piloto do aviao nulo.");
        }

        if(piloto.getFuncao() != "Piloto"){
            throw new IllegalArgumentException("Funcionario informado no aviao nao e piloto.");
        }

        this.piloto = piloto;
        this.partida = partida;
        this.destino = destino;
        this.passageiros = new ArrayList<Cliente>();
        this.integridadeAviao = new IntegridadeAviao(this);
    }

    public Aeroporto getPartida() {
        return this.partida;
    }

    public Aeroporto getDestino() {
        return this.destino;
    }

    public List<Cliente> getPassageiros() {
        return this.passageiros;
    }

    public void adicionaPassageiro(Cliente cliente){
        this.passageiros.add(cliente);
    }

    public IntegridadeAviao getIntegridadeAviao() {
        return this.integridadeAviao;
    }

    public class IntegridadeAviao{
        private boolean tanqueCheio;
        private boolean tremDePouso;

        IntegridadeAviao(Aviao aviao){     // inner class
            tanqueCheio = false;
            tremDePouso = false;
        }

        public void setTanqueCheio(boolean tanqueCheio) {
            this.tanqueCheio = tanqueCheio;
        }

        public void setTremDePouso(boolean tremDePouso) {
            this.tremDePouso = tremDePouso;
        }

        public void verificaComponentes(){
            if(!this.tanqueCheio){
                throw new IllegalArgumentException("ERRO! Tanque do Aviao nao esta cheio!");
            }

            if(!this.tremDePouso){
                throw new IllegalArgumentException("ERRO! Trem de Pouso do Aviao esta com defeito!");
            }
        }

        public boolean getIntegridadeDoAviao(){

            if(tanqueCheio && tremDePouso) {
                return true;
            }
            return false;
        }
    }
}
