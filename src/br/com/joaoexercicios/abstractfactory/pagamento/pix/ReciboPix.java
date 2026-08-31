package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável pela emissão do recibo referente a um pagamento
 * realizado por PIX.
 */

public class ReciboPix implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        return "Recibo PIX para "+pedido.getCliente();
    }
}
