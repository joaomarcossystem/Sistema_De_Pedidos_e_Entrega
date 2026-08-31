package br.com.joaoexercicios.abstractfactory.pagamento.cartao;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;

/**
 * Fábrica concreta responsável pela criação da família de produtos
 * relacionados ao pagamento com cartão.
 *
 * Cria o validador e o emissor de recibo específicos para cartão.
 */

public class CartaoAbstractFactory implements PagamentoAbstractFactory {
    @Override
    public ValidadorPagamento criarValidadorPagamento() {
        return new ValidadorCartao();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboCartao();
    }
}
