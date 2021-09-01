import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaoTest {
    @Test
    void testaPartidaNulo(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        try {
            Aviao aviao = new Aviao(null, aeroportoDestino, funcionario);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Partida do aviao nula.", e.getMessage());
        }
    }

    @Test
    void testaDestinoNulo(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisDestino, "Minas Gerais");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        try {
            Aviao aviao = new Aviao(aeroportoPartida, null, funcionario);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Destino do aviao nulo.", e.getMessage());
        }
    }

    @Test
    void testaPilotoNulo(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);


        try {
            Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Piloto do aviao nulo.", e.getMessage());
        }
    }

    @Test
    void testaFuncionarioNaoPiloto(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Comissário de Bordo");

        try {
            Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);
        }catch(IllegalArgumentException e){
            assertEquals("Funcionario informado no aviao nao e piloto.", e.getMessage());
        }
    }

    @Test
    void testaIntegridadeDoAviaoComDefeitoTremDePouso(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aviao.getIntegridadeAviao().setTremDePouso(false);
        aviao.getIntegridadeAviao().setTanqueCheio(true);

        assertFalse(aviao.getIntegridadeAviao().getIntegridadeDoAviao());
    }
    @Test
    void testaIntegridadeDoAviaoComTanqueVazio(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aviao.getIntegridadeAviao().setTremDePouso(true);
        aviao.getIntegridadeAviao().setTanqueCheio(false);

        assertFalse(aviao.getIntegridadeAviao().getIntegridadeDoAviao());
    }

    @Test
    void testaIntegridadeDoAviaoSemDefeito(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Pedro", paisDestino, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        aviao.getIntegridadeAviao().setTremDePouso(true);
        aviao.getIntegridadeAviao().setTanqueCheio(true);

        assertTrue(aviao.getIntegridadeAviao().getIntegridadeDoAviao());
    }
}