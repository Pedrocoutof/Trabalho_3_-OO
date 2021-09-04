// Nome: Pedro do Couto Filgueiras - 201935015
//       Gabriel Toledo Netto Gribel - 201976004

public class Pais {
    private String nomePais;

    Pais(String nomePais){
        if(nomePais == null){
            throw new IllegalArgumentException("ERRO! Nome do pais nulo.");
        }
        this.nomePais = nomePais;
    }

    public Pais getPais(){
        return this;
    }

    public String getNomePais() {
        return this.nomePais;
    }
}
