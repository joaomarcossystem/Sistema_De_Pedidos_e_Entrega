package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;

public class PixAbstractFactory implements PagamentoAbstractFactory {

    @Override
    public ValidadorPagamento criarValidadorPagamento() {
        return new ValidadorPix();
    }

    @Override
    public EmissorRecibo criarEmissorRecibo() {
        return new ReciboPix();
    }
}
