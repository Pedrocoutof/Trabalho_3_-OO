public abstract class Pessoa {
    private Pais naturalidade;
    private String nome;
    private boolean testeCovid;

    Pessoa(String nome, Pais naturalidade){
        if(nome == null){
            throw new IllegalArgumentException("ERRO! Nome da Pessoa nulo.");
        }

        if(naturalidade == null){
            throw new IllegalArgumentException("ERRO! Naturalidade da Pessoa nula.");
        }

        this.testeCovid = false;
        this.nome = nome;
        this.naturalidade = naturalidade;
    }

    public Pais getNaturalidade() {
        return naturalidade;
    }

    public void setTesteCovid(boolean covid) {
        this.testeCovid = covid;
    }

    public boolean getTesteCovid(){
        return testeCovid;
    }
}
