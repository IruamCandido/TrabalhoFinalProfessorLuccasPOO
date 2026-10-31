package br.edu.fagammon.estacionamento.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EstacionamentoTest {
    @Test
    public void testeGaranteInvarianteVeiculoNulo() {
        Estacionamento est = new Estacionamento();
        assertThrows(Exception.class, () -> {
            est.registrarEntrada(null);
        });
    }
}