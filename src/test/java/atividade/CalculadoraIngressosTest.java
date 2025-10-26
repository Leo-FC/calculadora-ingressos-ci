package atividade;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIngressosTest {

    // Instancia a unidade que será testada
    private final CalculadoraIngressos calc = new CalculadoraIngressos();

    // CT 1: Criança (Limite Superior: 12 anos, Preço 10)
    @Test
    void testCriancaLimiteSuperior() {
        // Esperado: 10 * 1 = 10
        assertEquals(10, calc.calcularValorIngresso(12, 1));
    }

    // CT 3: Adulto (Limite Inferior: 13 anos, Preço 30)
    @Test
    void testAdultoLimiteInferior() {
        // Esperado: 30 * 2 = 60
        assertEquals(60, calc.calcularValorIngresso(13, 2));
    }

    // CT 4: Adulto (Limite Superior: 59 anos, Qtd Máxima: 5)
    @Test
    void testAdultoLimiteSuperiorQtdMaxima() {
        // Esperado: 30 * 5 = 150
        assertEquals(150, calc.calcularValorIngresso(59, 5));
    }

    // CT 5: Idoso (Limite Inferior: 60 anos, Preço 15)
    @Test
    void testIdosoLimiteInferior() {
        // Esperado: 15 * 4 = 60
        assertEquals(60, calc.calcularValorIngresso(60, 4));
    }

    // CT 7: Quantidade Inválida (Qtd > 5)
    @Test
    void testQuantidadeExcessivaRetornaErro() {
        // Qtd 6. Deve retornar o código de erro -1
        assertEquals(-1, calc.calcularValorIngresso(30, 6));
    }
    
    // CT 8: Quantidade Zero (Qtd = 0)
    @Test
    void testQuantidadeNula() {
        // Qtd 0. Esperado: 0
        assertEquals(0, calc.calcularValorIngresso(30, 0));
    }
}
