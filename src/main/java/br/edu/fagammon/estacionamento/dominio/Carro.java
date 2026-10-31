package br.edu.fagammon.estacionamento.dominio;

public class Carro extends Veiculo {
    private final Porte porte;

    public Carro(String placa, Porte porte) {
        super(placa);
        this.porte = porte;
    }

    @Override
    public double calcularTaxa() {
        return 10.0; // Taxa fictícia para o teste
    }

    @Override
    public Porte porte() {
        return this.porte;
    }
}