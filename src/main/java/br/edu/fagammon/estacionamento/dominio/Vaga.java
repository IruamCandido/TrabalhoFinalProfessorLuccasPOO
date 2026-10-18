package br.edu.fagammon.estacionamento.dominio;

import java.util.Objects;

public class Vaga {
    private final String codigo;
    private final TipoVaga tipo;
    private boolean ativa;

    public Vaga(String codigo, TipoVaga tipo) {
        Objects.requireNonNull(codigo, "O código da vaga é obrigatório.");
        Objects.requireNonNull(tipo, "O tipo da vaga é obrigatório.");

        if (codigo.isBlank()) {
            throw new IllegalArgumentException("O código da vaga não pode ser vazio.");
        }

        this.codigo = codigo.trim().toUpperCase();
        this.tipo = tipo;
        this.ativa = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoVaga getTipo() {
        return tipo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void desativar() {
        this.ativa = false;
    }

    public void ativar() {
        this.ativa = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Objects.equals(codigo, vaga.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}