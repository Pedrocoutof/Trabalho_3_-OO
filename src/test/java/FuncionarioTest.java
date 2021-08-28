import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    @Test
    void testaFuncaoNull(){

        Pais naturalidade = new Pais("Brasil");

        try{
            Funcionario funcionario = new Funcionario("Gabriel", naturalidade, null);
        }catch(IllegalArgumentException e){
            assertEquals("ERRO! Funcao do funcionario nulo.", e.getMessage());
        }
    }

}