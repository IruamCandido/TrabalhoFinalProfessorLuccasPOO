package br.edu.fagammon.estacionamento.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LimitesTaxaTest {

    @Test
    public void testeLimiteZeroHorasNaoCobraTaxa() {
        Veiculo carro = new Carro("LIM-0000", Porte.MEDIO);
        assertEquals(0.0, carro.calcularTaxa(0), 0.01);
    }

    @Test
    public void testeLimiteMultiplasHorasCobrancaExata() {
        Veiculo carro = new Carro("LIM-9999", Porte.PEQUENO);
        assertEquals(50.0, carro.calcularTaxa(5), 0.01); // 5 horas * 10.0
    }
}