import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AeroportoTest {

    @Test
    void testaLocalNull(){
        try{
            Aeroporto aeroporto = new Aeroporto(null);
        }catch (IllegalArgumentException e){
            assertEquals("ERRO! Local do aeroporto nulo.", e.getMessage());
        }
    }

    @Test
    void testaSetAviaoNull(){
        Pais paisPartida = new Pais("Brasil");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        try{
            aeroportoPartida.setAviao(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Aviao informado na funcao 'setAviao' do aeroporto nulo.", e.getMessage());
        }

    }

    @Test
    void testaVerificaPassagemNull(){
        Pais pais = new Pais("Brasil");

        Estado estado = new Estado(pais, "Minas Gerais");

        Aeroporto aeroporto = new Aeroporto(estado);
        try{
            aeroporto.verificaPassagem(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Passagem informada no aeroporto nula.", e.getMessage());
        }
    }

    @Test
    void testaVerificaPassagemClienteSemCovid(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");
        Pais paisAutorizado = new Pais("Espanha");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        Passaporte passaporte = new Passaporte(cliente);
        passaporte.adicionaPais(paisAutorizado);

        aeroportoDestino.setAviao(aviao);

        cliente.setTesteCovid(false);

        assertEquals(false, aeroportoDestino.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemClienteComCovid(){
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

        aeroportoDestino.setAviao(aviao);

        cliente.setTesteCovid(true);

        assertFalse(aeroportoDestino.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemNaturalidadeClienteIgualDestinoVerdadeiro(){
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

        aeroportoPartida.setAviao(aviao);

        assertEquals(true, aeroportoPartida.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemNaturalidadeClienteIgualDestinoFalso(){
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

        aeroportoDestino.setAviao(aviao);

        assertEquals(false, aeroportoDestino.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemClienteSemPassaporte(){
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

        aeroportoDestino.setAviao(aviao);

        assertFalse(aeroportoDestino.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemClienteComPassaporteSemAutorizacao(){
        Pais paisPartida = new Pais("Brasil");
        Pais paisDestino = new Pais("Estado Unidos");
        Pais paisAutorizado = new Pais("Espanha");

        Estado estadoPartida = new Estado(paisPartida, "Minas Gerais");
        Estado estadoDestino = new Estado(paisDestino, "California");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario funcionario = new Funcionario("Gabriel", paisPartida, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, funcionario);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Pedro", paisPartida, passagem);

        Passaporte passaporte = new Passaporte(cliente);
        passaporte.adicionaPais(paisAutorizado);

        aeroportoDestino.setAviao(aviao);

        assertEquals(false, aeroportoDestino.verificaPassagem(passagem));
    }

    @Test
    void testaVerificaPassagemClienteComPassaporteComAutorizacao(){
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

        Passaporte passaporte = new Passaporte(cliente);
        passaporte.adicionaPais(paisDestino);

        aeroportoPartida.setAviao(aviao);

        assertTrue(aeroportoPartida.verificaPassagem(passagem));
    }

    @Test
    void verificaPassageirosEmbarcados(){
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

        Passaporte passaporte = new Passaporte(cliente);
        passaporte.adicionaPais(paisDestino);

        aeroportoPartida.setAviao(aviao);

        aeroportoPartida.embarcaPassageiro(passagem);

        assertEquals(aviao.getPassageiros().get(0), passagem.getCliente());
    }

}
/*

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

 */