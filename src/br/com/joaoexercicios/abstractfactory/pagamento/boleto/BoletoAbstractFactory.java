package br.com.joaoexercicios.abstractfactory.pagamento.boleto;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;

public class BoletoAbstractFactory implements PagamentoAbstractFactory {
    @Override
    public ValidadorPagamento criarValidadorPagamento() {
        return new ValidadorBoleto();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboBoleto();
    }
}
