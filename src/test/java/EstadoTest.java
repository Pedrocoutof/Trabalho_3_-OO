import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoTest {
    @Test
    void testaNomeEstadoNull(){
        Pais pais = new Pais("Brasil");

        try{
            Estado estado = new Estado(pais, null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Nome do estado nulo.", e.getMessage());
        }
    }

    @Test
    void testaGetNomeEstado(){
        Pais pais = new Pais("Brasil");
        Estado estado = new Estado(pais, "Minas Gerais");

        assertEquals(pais.getNomePais(), estado.getPais().getNomePais());
        assertEquals("Minas Gerais", estado.getNomeEstado());
    }

    @Test
    void testaGetNomePaisPeloEstado(){
        Pais pais = new Pais("Brasil");
        Estado estado = new Estado(pais, "Minas Gerais");

        assertEquals(pais.getNomePais(), estado.getPais().getNomePais());
        assertEquals("Brasil", estado.getPais().getNomePais());
    }
}