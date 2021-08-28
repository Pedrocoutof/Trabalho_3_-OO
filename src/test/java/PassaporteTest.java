import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassaporteTest {

    @Test
    void testaClienteNulo(){
        try{
            Passaporte passaporte = new Passaporte(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Cliente do passaporte nulo.", e.getMessage());
        }
    }

    @Test
    void testaAdicionaPaisNulo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        Passaporte passaporte = new Passaporte(cliente);

        try{
            passaporte.adicionaPais(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Pais do passaporte nulo.", e.getMessage());
        }
    }

    @Test
    void testaPaisAutorizadoSemPais(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        Passaporte passaporte = new Passaporte(cliente);

        assertEquals(0, passaporte.getPaisAutorizado().size());
    }

    @Test
    void testaAdicionaUmPais(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        Passaporte passaporte = new Passaporte(cliente);

        Pais paisAutorizado = new Pais("Espanha");

        passaporte.adicionaPais(paisAutorizado);

        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado));
        assertEquals(1, passaporte.getPaisAutorizado().size());
    }

    @Test
    void testaAdicionaUmOuMaisPais(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);
        Passaporte passaporte = new Passaporte(cliente);

        Pais paisAutorizado1 = new Pais("Espanha");
        Pais paisAutorizado2 = new Pais("Egito");
        Pais paisAutorizado3 = new Pais("Russia");

        passaporte.adicionaPais(paisAutorizado1);
        passaporte.adicionaPais(paisAutorizado2);
        passaporte.adicionaPais(paisAutorizado3);

        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado1));
        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado2));
        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado3));
        assertEquals(3, passaporte.getPaisAutorizado().size());
    }

    @Test
    void testaRemocaoPaisEnviandoPaisNulo(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);
        Passaporte passaporte = new Passaporte(cliente);

        try{
            passaporte.removePais(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Pais do passaporte nulo.", e.getMessage());
        }
    }

    @Test
    void testaRemocaoPaisNaoAutorizado(){

        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);
        Passaporte passaporte = new Passaporte(cliente);

        Pais paisAutorizado1 = new Pais("Espanha");
        Pais paisAutorizado2 = new Pais("Egito");
        Pais paisAutorizado3 = new Pais("Russia");

        Pais paisNaoAutorizado = new Pais("Italia");

        passaporte.adicionaPais(paisAutorizado1);
        passaporte.adicionaPais(paisAutorizado2);
        passaporte.adicionaPais(paisAutorizado3);

        try{
            passaporte.removePais(paisNaoAutorizado);
        }catch (IllegalArgumentException e){
            assertEquals("ERRO! Pais do informado nao possui na lista de paises autorizados.", e.getMessage());
        }
    }

    @Test
    void TestaRemocaoPaisAutorizado(){


        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estados Unidos");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino,funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);
        Passaporte passaporte = new Passaporte(cliente);

        Pais paisAutorizado1 = new Pais("Espanha");
        Pais paisAutorizado2 = new Pais("Egito");
        Pais paisAutorizado3 = new Pais("Russia");

        passaporte.adicionaPais(paisAutorizado1);
        passaporte.adicionaPais(paisAutorizado2);
        passaporte.adicionaPais(paisAutorizado3);

        passaporte.removePais(paisAutorizado2);

        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado1));
        assertEquals(false, passaporte.getPaisAutorizado().contains(paisAutorizado2));
        assertEquals(true, passaporte.getPaisAutorizado().contains(paisAutorizado3));
        assertEquals(2, passaporte.getPaisAutorizado().size());
    }

}