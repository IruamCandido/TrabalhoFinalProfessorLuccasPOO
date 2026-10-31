package br.edu.fagammon.estacionamento.dominio;

public class Estacionamento {
    private final Repositorio<Veiculo> veiculos = new Repositorio<>(); 
    
    public void registrarEntrada(Veiculo v) throws Exception {
        if (v == null) {
            throw new Exception("Falha de Invariante: O veículo não pode ser nulo.");
        }
        veiculos.adicionar(v);
    }
}