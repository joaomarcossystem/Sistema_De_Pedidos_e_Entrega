package br.com.joaoexercicios.factorymethod.entrega;

import br.com.joaoexercicios.model.Pedido;

/**
 * Define o produto abstrato do sistema de entregas.
 *
 * Estabelece as operações que devem ser implementadas
 * pelos diferentes tipos de entrega disponíveis no sistema.
 */

public interface Entrega {
    public int calcularPrazoEmDias();
    public void realizarEntrega(Pedido pedido);

}
