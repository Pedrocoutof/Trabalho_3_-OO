import java.util.List;
import java.util.ArrayList;

public class Passaporte {
    private List<Pais> paisAutorizado;
    private Cliente cliente;

    Passaporte(Cliente cliente){
        if(cliente == null){
            throw new IllegalArgumentException("ERRO! Cliente do passaporte nulo.");
        }

        this.cliente = cliente;
        this.cliente.setPassaporte(this);
        this.paisAutorizado = new ArrayList<Pais>();
    }

    public void adicionaPais(Pais paisAutorizado) {
        if(paisAutorizado == null){
            throw new IllegalArgumentException("ERRO! Pais do passaporte nulo.");
        }
        this.paisAutorizado.add(paisAutorizado);
    }

    public void removePais(Pais pais){
        if(pais == null){
            throw new IllegalArgumentException("ERRO! Pais do passaporte nulo.");
        }
        if(!this.paisAutorizado.contains(pais)){
            throw new IllegalArgumentException("ERRO! Pais do informado nao possui na lista de paises autorizados.");
        }
        this.paisAutorizado.remove(pais);
    }

    public List<Pais> getPaisAutorizado() {
        return this.paisAutorizado;
    }
}