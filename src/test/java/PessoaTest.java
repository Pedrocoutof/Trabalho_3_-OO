import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void testaPessoaClienteComNomeNulo(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario piloto = new Funcionario("Pedro", pais, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, piloto);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        try{
            Cliente cliente = new Cliente(null, pais, passagem);
        }catch(IllegalArgumentException e) {
            assertEquals("ERRO! Nome da Pessoa nulo.", e.getMessage());
        }
    }

    @Test
    void testaPessoaClienteComNaturalidadeNula(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario piloto = new Funcionario("Pedro", pais, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, piloto);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        try{
            Cliente cliente = new Cliente("Gabriel", null, passagem);
        }catch(IllegalArgumentException e) {
            assertEquals("ERRO! Naturalidade da Pessoa nula.", e.getMessage());
        }
    }

    @Test
    void testaPessoaFuncionarioComNomeNulo(){

        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        try{
            Funcionario piloto = new Funcionario(null, pais, "Piloto");
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Nome da Pessoa nulo.", e.getMessage());
        }
    }

    @Test
    void testaPessoaFuncionarioComNaturalidadeNula(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        try{
            Funcionario funcionario = new Funcionario("Gabriel", null, "Piloto");
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Naturalidade da Pessoa nula.", e.getMessage());
        }
    }

    @Test
    void testGetNaturalidadePeloFuncionario(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Funcionario funcionario = new Funcionario("Pedro", pais, "Piloto");

        assertEquals(funcionario.getNaturalidade(), pais);
    }

    @Test
    void testGetNaturalidadePeloCliente(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario piloto = new Funcionario("Pedro", pais, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, piloto);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Gabriel", pais, passagem);

        assertEquals(cliente.getNaturalidade(), pais);
    }

    @Test
    void testaCovidClienteFalse(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario piloto = new Funcionario("Pedro", pais, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, piloto);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Gabriel", pais, passagem);

        cliente.setTesteCovid(false);

        assertFalse(cliente.getTesteCovid());
    }
    @Test
    void testaCovidClienteTrue(){
        Pais pais = new Pais("Brasil");

        Estado estadoPartida = new Estado(pais, "Minas Gerais");
        Estado estadoDestino = new Estado(pais, "São Paulo");

        Aeroporto aeroportoPartida = new Aeroporto(estadoPartida);
        Aeroporto aeroportoDestino = new Aeroporto(estadoDestino);

        Funcionario piloto = new Funcionario("Pedro", pais, "Piloto");

        Aviao aviao = new Aviao(aeroportoPartida, aeroportoDestino, piloto);

        Passagem passagem = new Passagem(aeroportoPartida, aeroportoDestino, aviao);

        Cliente cliente = new Cliente("Gabriel", pais, passagem);

        cliente.setTesteCovid(true);

        assertTrue(cliente.getTesteCovid());
    }

}