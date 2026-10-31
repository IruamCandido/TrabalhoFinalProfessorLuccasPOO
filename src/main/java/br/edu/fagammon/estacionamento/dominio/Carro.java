package br.edu.fagammon.estacionamento.dominio;

public class Carro extends Veiculo {
    private final Porte porte;

    public Carro(String placa, Porte porte) {
        super(placa, new CalculoTaxaPadrao(10.0));
        this.porte = porte;
    }

    @Override
    public Porte porte() {
        return this.porte;
    }
}