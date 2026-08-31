package br.com.joaoexercicios.abstractfactory.pagamento.cartao;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável por validar pagamentos realizados com cartão.
 *
 * Implementa as regras específicas de validação do pagamento
 * por cartão definidas pelo sistema.
 */

public class ValidadorCartao implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=10){
            return false;
        }
        return true;
    }
}
