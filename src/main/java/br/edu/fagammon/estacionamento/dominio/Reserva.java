package br.edu.fagammon.estacionamento.dominio;

import br.edu.fagammon.estacionamento.excecao.RegraNegocioException;
import java.util.Objects;

public class Reserva {
    private final String id;
    private final Vaga vaga;
    private final Veiculo veiculo;
    private final Periodo periodo;

    public Reserva(String id, Vaga vaga, Veiculo veiculo, Periodo periodo) {
        this.id = Objects.requireNonNull(id, "ID da reserva não pode ser nulo.");
        this.vaga = Objects.requireNonNull(vaga, "Vaga não pode ser nula.");
        this.veiculo = Objects.requireNonNull(veiculo, "Veículo não pode ser nulo.");
        this.periodo = Objects.requireNonNull(periodo, "Período não pode ser nulo.");

        validarInvariantes();
    }

    private void validarInvariantes() {
        if (!vaga.isAtiva()) {
            throw new RegraNegocioException("Não é possível reservar uma vaga inativa.");
        }

        if (!vaga.getTipo().aceitaPorte(veiculo.porte())) {
            throw new RegraNegocioException("O porte do veículo é incompatível com o tipo de vaga.");
        }
    }

    public boolean conflitaCom(Vaga outraVaga, Periodo outroPeriodo) {
        return this.vaga.equals(outraVaga) && this.periodo.sobrepoe(outroPeriodo);
    }

    public String getId() {
        return id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}