package br.com.joaoexercicios.abstractfactory.pagamento.boleto;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.model.Pedido;

public class ReciboBoleto implements EmissorRecibo {
    @Override
    public String emitir(Pedido pedido) {
        return "Recibo Boleto para "+pedido.getCliente();
    }
}
