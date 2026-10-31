package br.edu.fagammon.estacionamento.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EstacionamentoTest {
    
    @Test
    public void testeGaranteInvarianteVeiculoNulo() {
        Estacionamento est = new Estacionamento();
        
        Exception erro = assertThrows(Exception.class, () -> {
            est.registrarEntrada(null);
        });
        
        // Valida se a mensagem da exceção é exatamente a esperada
        assertEquals("Falha de Invariante: O veículo não pode ser nulo.", erro.getMessage());
    }
}