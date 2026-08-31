package br.com.joaoexercicios.abstractfactory.pagamento;

import br.com.joaoexercicios.model.Pedido;
/**
 * Define o produto abstrato responsável por validar um pagamento.
 *
 * Cada forma de pagamento possui sua própria implementação
 * dessa interface, permitindo realizar a validação de acordo
 * com as regras específicas do pagamento.
 */
public interface ValidadorPagamento {

    public boolean validar(Pedido pedido);

}
