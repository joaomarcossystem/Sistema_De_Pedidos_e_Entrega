package br.com.joaoexercicios.service;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

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
