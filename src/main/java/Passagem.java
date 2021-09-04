// Nome: Pedro do Couto Filgueiras - 201935015
//       Gabriel Toledo Netto Gribel - 201976004

public class Passagem {
    private Cliente cliente;
    private Aeroporto partida;
    private Aeroporto destino;
    private Aviao aviao;

    Passagem(Aeroporto partida, Aeroporto destino, Aviao aviao){
        if (partida == null) {
            throw new IllegalArgumentException("ERRO! Partida na passagem nulo.");
        }
        if (destino == null) {
            throw new IllegalArgumentException("ERRO! Destino na passagem nulo.");
        }
        if (aviao == null) {
            throw new IllegalArgumentException("ERRO! Aviao na passagem nulo.");
        }

        this.partida = partida;
        this.destino = destino;
        this.aviao = aviao;
        this.cliente = null;
    }

    public void setCliente(Cliente cliente) {
        if(cliente == null){
            throw new IllegalArgumentException("ERRO! Cliente na funcao 'setCliente' da passagem nulo.");
        }
        if(this.cliente != null) {
            throw new IllegalArgumentException("ERRO! Passagem já possui cliente.");
        }
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Estado getEstadoPartida(){
        return this.partida.getLocal();
    }

    public Estado getEstadoDestino() {
        return this.destino.getLocal();
    }
}


