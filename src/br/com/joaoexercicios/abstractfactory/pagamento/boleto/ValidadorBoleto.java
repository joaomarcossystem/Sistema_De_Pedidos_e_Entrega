package br.com.joaoexercicios.abstractfactory.pagamento.boleto;

import br.com.joaoexercicios.abstractfactory.pagamento.ValidadorPagamento;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável por validar pagamentos realizados por boleto.
 *
 * Implementa as regras específicas de validação do pagamento
 * por boleto definidas pelo sistema.
 */

public class ValidadorBoleto implements ValidadorPagamento {
    @Override
    public boolean validar(Pedido pedido) {
        if(pedido.getValor()<=0){
            return false;
        }
        return true;
    }
}
