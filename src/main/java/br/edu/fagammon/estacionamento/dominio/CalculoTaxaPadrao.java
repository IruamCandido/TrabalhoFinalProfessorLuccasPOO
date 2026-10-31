package br.edu.fagammon.estacionamento.dominio;

public class CalculoTaxaPadrao implements CalculoTaxa {
    private final double valorHora;

    public CalculoTaxaPadrao(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcular(long horasEstacionadas) {
        if (horasEstacionadas <= 0) return 0.0;
        return horasEstacionadas * valorHora;
    }
}