package br.com.joaoexercicios.service;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável por coordenar o processamento dos pagamentos.
 *
 * Utiliza uma fábrica abstrata para criar o validador e o emissor
 * de recibo correspondentes à forma de pagamento escolhida.
 */

public class ServicoPagamento {

    private PagamentoAbstractFactory  pagamentoAbstractFactory;

    public ServicoPagamento(PagamentoAbstractFactory pagamentoAbstractFactory) {
        this.pagamentoAbstractFactory = pagamentoAbstractFactory;
    }

    public String processar (Pedido pedido){
        ValidadorPagamento validadorPagamento = pagamentoAbstractFactory.criarValidadorPagamento();

        if(validadorPagamento.validar(pedido) == false){
            throw new IllegalArgumentException("Pagamento inválido");
        }

        EmissorRecibo emissorRecibo =  pagamentoAbstractFactory.criarEmissorRecibo();

        return emissorRecibo.emitir(pedido);
    }
}
