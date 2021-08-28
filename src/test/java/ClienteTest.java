import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void testaClienteComPassagemNull(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        try{
            Cliente cliente = new Cliente("Pedro", paisPartida, null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Passagem do cliente nula.", e.getMessage());
        }
    }

    @Test
    void verificaSePassagemContemClienteSimultaneamente(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        assertEquals(cliente, passagem.getCliente());
        assertEquals(passagem, cliente.getPassagem());
    }

    @Test
    void testaSetPassaporteNull(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        try{
            cliente.setPassaporte(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Passaporte informado na funcao 'setPassaporte' do cliente nulo.", e.getMessage());
        }
    }

}