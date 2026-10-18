package br.edu.fagammon.estacionamento.dominio;

import java.util.Objects;

public record Veiculo(String placa, Porte porte) {

    public Veiculo {
        Objects.requireNonNull(placa, "A placa é obrigatória.");
        Objects.requireNonNull(porte, "O porte é obrigatório.");

        String placaLimpa = placa.trim().toUpperCase();
        if (placaLimpa.isBlank()) {
            throw new IllegalArgumentException("A placa não pode ser vazia.");
        }
        placa = placaLimpa;
    }
}