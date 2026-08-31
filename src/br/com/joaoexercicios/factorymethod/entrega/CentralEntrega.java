package br.com.joaoexercicios.factorymethod.entrega;

import br.com.joaoexercicios.model.Pedido;

public abstract class CentralEntrega {

    protected abstract Entrega criarEntrega();

    public void processarPedido(Pedido pedido){
        Entrega entrega = criarEntrega();
        entrega.realizarEntrega(pedido);
        System.out.println("Prazo estimado: "+entrega.calcularPrazoEmDias()+" dias.");
    }
}
