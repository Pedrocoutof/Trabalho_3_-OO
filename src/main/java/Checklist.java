public class Checklist {

    Checklist(Aeroporto.Meteorologia meteorologiaAeroportoPartida, Aeroporto.Meteorologia meteorologiaAeroportoDestino, Aviao aviao){

        if(meteorologiaAeroportoPartida == null){
            throw new IllegalArgumentException("Aeroporto de partida informado no checkList nulo.");
        }

        if(meteorologiaAeroportoDestino == null){
            throw new IllegalArgumentException("Aeroporto de destino informado no checkList nulo.");
        }

        if(aviao == null){
            throw new IllegalArgumentException("Aviao informado no checkList nulo.");
        }

        if(!meteorologiaAeroportoPartida.getPossibilidadeVoo()){
            throw new IllegalArgumentException("Voo NAO aprovado pelo departamento de meteorologia do aeroporto de partida");
        }

        if(!meteorologiaAeroportoDestino.getPossibilidadeVoo()){
            throw new IllegalArgumentException("Voo NAO aprovado pelo departamento de meteorologia aeroporto de destino");
        }

        if(!aviao.getIntegridadeAviao().getIntegridadeDoAviao()){
            throw new IllegalArgumentException("Aviao SEM condicao de voo!");
        }

    }
}
