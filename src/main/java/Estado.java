// Nome: Pedro do Couto Filgueiras - 201935015
//       Gabriel Toledo Netto Gribel - 201976004

public class Estado{
    private String nomeEstado;
    private Pais pais;


    Estado(Pais pais, String nomeEstado){
        if(pais == null){
            throw new IllegalArgumentException("ERRO! Pais do estado nulo.");
        }

        if(nomeEstado == null){
            throw new IllegalArgumentException("ERRO! Nome do estado nulo.");
        }

        this.pais = pais;
        this.nomeEstado = nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }
}
