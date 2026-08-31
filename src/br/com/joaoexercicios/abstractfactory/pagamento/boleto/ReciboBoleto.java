package br.com.joaoexercicios.abstractfactory.pagamento.boleto;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.model.Pedido;

/**
 * Responsável pela emissão do recibo referente a um pagamento
 * realizado por boleto.
 */

public class ReciboBoleto implements EmissorRecibo {
    @Override
    public String emitir(Pedido pedido) {
        return "Recibo Boleto para "+pedido.getCliente();
    }
}
