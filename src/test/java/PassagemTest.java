import org.junit.jupiter.api.Test;

import java.lang.ref.Cleaner;

import static org.junit.jupiter.api.Assertions.*;

class PassagemTest {
    @Test
    void testaPartidaNull() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);
        try{
            Passagem passagem = new Passagem(null, aeroportoDestino, aviao);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Partida na passagem nulo.", e.getMessage());
        }
    }

    @Test
    void testaDestinoNull() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);
        try{
            Passagem passagem = new Passagem(aeroportoPartida, null, aviao);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Destino na passagem nulo.", e.getMessage());
        }
    }

    @Test
    void testaAviaoNull() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        try{
            Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Aviao na passagem nulo.", e.getMessage());
        }
    }

    @Test
    void testaSetClienteNull() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);
        try{
            passagem.setCliente(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Cliente na funcao 'setCliente' da passagem nulo.", e.getMessage());
        }
    }

    @Test
    void testaSetClienteComPassagemComDono() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente1 = new Cliente("Pedro", paisDestino, passagem);

        try{
            Cliente cliente2 = new Cliente("João", paisDestino, passagem);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Passagem já possui cliente.", e.getMessage());
        }
    }

    @Test
    void testaLocalDePartidaPassagem() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisDestino, passagem);

        assertEquals(passagem.getEstadoPartida().getNomeEstado(), aviao.getPartida().getLocal().getNomeEstado());
    }

    @Test
    void testaDestinoPassagemAviao() {
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisDestino, passagem);

        assertEquals(passagem.getEstadoDestino().getNomeEstado(), aviao.getDestino().getLocal().getNomeEstado());
    }


}