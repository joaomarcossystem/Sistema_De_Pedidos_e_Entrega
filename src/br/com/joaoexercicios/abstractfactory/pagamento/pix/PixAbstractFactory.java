package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;

/**
 * Fábrica concreta responsável pela criação da família de produtos
 * relacionados ao pagamento por PIX.
 *
 * Cria o validador e o emissor de recibo específicos para PIX.
 */

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
