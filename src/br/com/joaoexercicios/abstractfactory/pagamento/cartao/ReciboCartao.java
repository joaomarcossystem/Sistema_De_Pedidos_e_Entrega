package br.com.joaoexercicios.abstractfactory.pagamento.cartao;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável pela emissão do recibo referente a um pagamento
 * realizado com cartão.
 */

public class ReciboCartao implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        return "Recibo Cartao para "+pedido.getCliente();
    }
}
