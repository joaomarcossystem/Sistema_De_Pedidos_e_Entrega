package br.com.joaoexercicios.factorymethod.entrega;

import br.com.joaoexercicios.model.Pedido;

/**
 * Define a fábrica abstrata responsável por estabelecer
 * o fluxo de processamento das entregas.
 *
 * Utiliza o Factory Method para permitir que as subclasses
 * definam qual tipo concreto de entrega será criado.
 */

public abstract class CentralEntrega {

    protected abstract Entrega criarEntrega();

    public void processarPedido(Pedido pedido){
        Entrega entrega = criarEntrega();
        entrega.realizarEntrega(pedido);
        System.out.println("Prazo estimado: "+entrega.calcularPrazoEmDias()+" dias.");
    }
}
