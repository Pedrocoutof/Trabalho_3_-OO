import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChecklistTest {

    @Test
    void testaAeroportoPartidaNulo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        try{
            Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);
            Checklist checklist = new Checklist(null, aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Aeroporto de partida informado no checkList nulo.", e.getMessage());
        }
    }

    @Test
    void testaAeroportoDestinoNulo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        try{
            Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), null, aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Aeroporto de destino informado no checkList nulo.", e.getMessage());
        }
    }

    @Test
    void testaAviaoNulo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), null);
        }catch(IllegalArgumentException e){
            assertEquals("Aviao informado no checkList nulo.", e.getMessage());
        }
    }

    @Test
    void testaAeroportoPartidaSemVisibilidade(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(false);
        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Voo NAO aprovado pelo departamento de meteorologia do aeroporto de partida", e.getMessage());
        }
    }

    @Test
    void testaAeroportoPartidaSemCondicoesDeVoo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(true);
        aeroportoPartida.getMeteorologia().setCondicaoDeVoo(false);

        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Voo NAO aprovado pelo departamento de meteorologia do aeroporto de partida", e.getMessage());
        }
    }

    @Test
    void testaAeroportoDestinoSemVisibilidade(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(true);
        aeroportoPartida.getMeteorologia().setCondicaoDeVoo(true);

        aeroportoDestino.getMeteorologia().setVisibilidade(false);
        aeroportoDestino.getMeteorologia().setCondicaoDeVoo(true);

        aviao.setCondicaoMotor(true);
        aviao.setTanqueCheio(true);

        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Voo NAO aprovado pelo departamento de meteorologia aeroporto de destino", e.getMessage());
        }
    }

    @Test
    void testaAeroportoDestinoSemCondicoesDeVoo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(true);
        aeroportoPartida.getMeteorologia().setCondicaoDeVoo(true);

        aeroportoDestino.getMeteorologia().setVisibilidade(true);
        aeroportoDestino.getMeteorologia().setCondicaoDeVoo(false);

        aviao.setCondicaoMotor(true);
        aviao.setTanqueCheio(true);

        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Voo NAO aprovado pelo departamento de meteorologia aeroporto de destino", e.getMessage());
        }
    }

    @Test
    void testaAviaoComDefeitoTremDePouso(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(true);
        aeroportoPartida.getMeteorologia().setCondicaoDeVoo(true);

        aeroportoDestino.getMeteorologia().setVisibilidade(true);
        aeroportoDestino.getMeteorologia().setCondicaoDeVoo(true);

        aviao.setCondicaoMotor(false);
        aviao.setTanqueCheio(true);

        try{
            Checklist checklist2 = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Aviao SEM possibilidade de voo!", e.getMessage());
        }
    }

    @Test
    void testaAviaoComTanqueVazio(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aeroportoPartida.getMeteorologia().setVisibilidade(true);
        aeroportoPartida.getMeteorologia().setCondicaoDeVoo(true);

        aeroportoDestino.getMeteorologia().setVisibilidade(true);
        aeroportoDestino.getMeteorologia().setCondicaoDeVoo(true);

        aviao.setCondicaoMotor(true);
        aviao.setTanqueCheio(false);

        try{
            Checklist checklist = new Checklist(aeroportoPartida.getMeteorologia(), aeroportoDestino.getMeteorologia(), aviao);
        }catch(IllegalArgumentException e){
            assertEquals("Aviao SEM possibilidade de voo!", e.getMessage());
        }
    }

}