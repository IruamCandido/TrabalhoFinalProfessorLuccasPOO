package br.edu.fagammon.estacionamento.dominio;

public abstract class Veiculo {
    protected String placa;
    
    public Veiculo(String placa) { 
        this.placa = placa; 
    }
    
    public abstract double calcularTaxa();
}