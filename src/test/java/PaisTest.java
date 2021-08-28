import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaisTest {
    @Test
    void testaNomePaisNulo(){
        try{
            Pais pais = new Pais(null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Nome do pais nulo.", e.getMessage());
        }
    }

    @Test
    void testaGetPais(){
        Pais pais = new Pais("Brasil");
        assertEquals(pais, pais.getPais());
    }

}