package br.edu.fagammon.estacionamento.dominio;

public enum TipoVaga {
    MOTO(Porte.PEQUENO),
    PADRAO(Porte.MEDIO),
    VIP_SUV(Porte.GRANDE);

    private final Porte porteMaximoAtendido;

    TipoVaga(Porte porteMaximoAtendido) {
        this.porteMaximoAtendido = porteMaximoAtendido;
    }

    public boolean aceitaPorte(Porte porteVeiculo) {
        return porteVeiculo.ordinal() <= this.porteMaximoAtendido.ordinal();
    }
}