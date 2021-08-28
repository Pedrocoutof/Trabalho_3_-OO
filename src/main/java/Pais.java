public class Pais {
    String nomePais;

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
