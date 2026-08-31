package br.com.joaoexercicios.abstractfactory.pagamento.cartao;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

public class ValidadorCartao implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=10){
            return false;
        }
        return true;
    }
}
