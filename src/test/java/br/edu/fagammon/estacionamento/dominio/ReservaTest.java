package br.edu.fagammon.estacionamento.dominio;

import br.edu.fagammon.estacionamento.excecao.RegraNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    @Test
    @DisplayName("Deve criar reserva com sucesso quando os dados forem válidos")
    void deveCriarReservaValida() {
        Vaga vaga = new Vaga("A101", TipoVaga.PADRAO);
        Veiculo veiculo = new Veiculo("ABC1D23", Porte.MEDIO);
        Periodo periodo = new Periodo(
            LocalDateTime.of(2026, 10, 20, 8, 0),
            LocalDateTime.of(2026, 10, 20, 18, 0)
        );

        Reserva reserva = new Reserva("RES-001", vaga, veiculo, periodo);

        assertNotNull(reserva);
        assertEquals("RES-001", reserva.getId());
    }

    @Test
    @DisplayName("Deve rejeitar reserva em vaga inativa")
    void deveRejeitarReservaEmVagaInativa() {
        Vaga vaga = new Vaga("A102", TipoVaga.PADRAO);
        vaga.desativar();

        Veiculo veiculo = new Veiculo("XYZ9876", Porte.PEQUENO);
        Periodo periodo = new Periodo(
            LocalDateTime.of(2026, 10, 20, 8, 0),
            LocalDateTime.of(2026, 10, 20, 10, 0)
        );

        assertThrows(RegraNegocioException.class, () -> new Reserva("RES-002", vaga, veiculo, periodo));
    }

    @Test
    @DisplayName("Deve rejeitar veículo grande em vaga de moto")
    void deveRejeitarPorteIncompativel() {
        Vaga vagaMoto = new Vaga("M01", TipoVaga.MOTO);
        Veiculo suv = new Veiculo("SUV1234", Porte.GRANDE);
        Periodo periodo = new Periodo(
            LocalDateTime.of(2026, 10, 20, 8, 0),
            LocalDateTime.of(2026, 10, 20, 10, 0)
        );

        assertThrows(RegraNegocioException.class, () -> new Reserva("RES-003", vagaMoto, suv, periodo));
    }

    @Test
    @DisplayName("Deve identificar conflito de agenda para a mesma vaga")
    void deveIdentificarConflitoDeAgenda() {
        Vaga vaga = new Vaga("A101", TipoVaga.PADRAO);
        Veiculo veiculo1 = new Veiculo("ABC1D23", Porte.MEDIO);
        Periodo periodo1 = new Periodo(
            LocalDateTime.of(2026, 10, 20, 10, 0),
            LocalDateTime.of(2026, 10, 20, 12, 0)
        );

        Reserva reservaExistente = new Reserva("RES-001", vaga, veiculo1, periodo1);

        Periodo periodoConflitante = new Periodo(
            LocalDateTime.of(2026, 10, 20, 11, 0),
            LocalDateTime.of(2026, 10, 20, 13, 0)
        );

        assertTrue(reservaExistente.conflitaCom(vaga, periodoConflitante));
    }
}