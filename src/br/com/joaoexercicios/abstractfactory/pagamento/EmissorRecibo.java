package br.com.joaoexercicios.abstractfactory.pagamento;

import br.com.joaoexercicios.model.Pedido;

/**
 * Define o produto abstrato responsável pela emissão do recibo
 * de um pagamento.
 *
 * Cada forma de pagamento possui sua própria implementação
 * dessa interface para emitir o recibo correspondente.
 */

public interface EmissorRecibo {

    public String emitir(Pedido pedido);

}
