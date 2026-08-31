package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável por validar pagamentos realizados por PIX.
 *
 * Implementa as regras específicas de validação do pagamento
 * por PIX definidas pelo sistema.
 */

public class ValidadorPix implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=0){
            return false;
        }
        return true;
    }
}
