package br.edu.fagammon.estacionamento.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PeriodoTest {

    @Test
    @DisplayName("Deve criar período válido quando inicio for anterior ao fim")
    void deveCriarPeriodoValido() {
        LocalDateTime inicio = LocalDateTime.of(2026, 10, 20, 10, 0);
        LocalDateTime fim = LocalDateTime.of(2026, 10, 20, 12, 0);

        Periodo periodo = new Periodo(inicio, fim);

        assertEquals(inicio, periodo.inicio());
        assertEquals(fim, periodo.fim());
    }

    @Test
    @DisplayName("Deve rejeitar período onde o início é igual ou posterior ao fim")
    void deveRejeitarPeriodoInvalido() {
        LocalDateTime agora = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> new Periodo(agora, agora));
        assertThrows(IllegalArgumentException.class, () -> new Periodo(agora.plusHours(1), agora));
    }

    @Test
    @DisplayName("Deve detectar sobreposição de períodos corretamente")
    void deveDetectarSobreposicao() {
        Periodo p1 = new Periodo(
            LocalDateTime.of(2026, 10, 20, 10, 0),
            LocalDateTime.of(2026, 10, 20, 12, 0)
        );

        Periodo p2 = new Periodo(
            LocalDateTime.of(2026, 10, 20, 11, 0),
            LocalDateTime.of(2026, 10, 20, 13, 0)
        );

        Periodo p3SemConflito = new Periodo(
            LocalDateTime.of(2026, 10, 20, 12, 0),
            LocalDateTime.of(2026, 10, 20, 14, 0)
        );

        assertTrue(p1.sobrepoe(p2));
        assertFalse(p1.sobrepoe(p3SemConflito));
    }
}