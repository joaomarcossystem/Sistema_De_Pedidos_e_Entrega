package br.com.joaoexercicios.abstractfactory.pagamento.cartao;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;

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
