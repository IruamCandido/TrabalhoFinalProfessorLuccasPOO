package br.edu.fagammon.estacionamento.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public record Periodo(LocalDateTime inicio, LocalDateTime fim) {

    public Periodo {
        Objects.requireNonNull(inicio, "A data de início é obrigatória.");
        Objects.requireNonNull(fim, "A data de fim é obrigatória.");

        if (!inicio.isBefore(fim)) {
            throw new IllegalArgumentException("A data de início deve ser estritamente anterior à data de fim.");
        }
    }

    public boolean sobrepoe(Periodo outro) {
        Objects.requireNonNull(outro, "O outro período não pode ser nulo.");
        return this.inicio.isBefore(outro.fim) && outro.inicio.isBefore(this.fim);
    }
}