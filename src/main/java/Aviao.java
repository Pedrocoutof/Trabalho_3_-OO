import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private Aeroporto partida;
    private Aeroporto destino;
    private Funcionario piloto;
    private List<Cliente> passageiros;
    // private final int LOTACAO_MAX = 3; //Valor baixo para facilar o teste do limite

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

    /*
     public int getLOTACAO_MAX() {
        return LOTACAO_MAX;
    }
    */

    public void adicionaPassageiro(Cliente cliente){
        this.passageiros.add(cliente);
    }
}
