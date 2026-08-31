package br.com.joaoexercicios.abstractfactory.pagamento.boleto;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

public class ValidadorBoleto implements ValidadorPagamento {
    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=0){
            return false;
        }
        return true;
    }
}
