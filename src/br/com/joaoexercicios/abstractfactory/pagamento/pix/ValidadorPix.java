package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

public class ValidadorPix implements ValidadorPagamento {

    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=0){
            return false;
        }
        return true;
    }
}
