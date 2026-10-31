package br.edu.fagammon.estacionamento.dominio;

public abstract class Veiculo {
    protected final String placa;
    protected final CalculoTaxa calculoTaxa;
    
    public Veiculo(String placa, CalculoTaxa calculoTaxa) { 
        this.placa = placa; 
        this.calculoTaxa = calculoTaxa;
    }
    
    public double calcularTaxa(long horas) {
        return calculoTaxa.calcular(horas);
    }
    
    public abstract Porte porte(); 
}
