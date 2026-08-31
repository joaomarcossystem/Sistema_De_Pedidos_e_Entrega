package br.com.joaoexercicios.abstractfactory.pagamento.pix;

import br.com.joaoexercicios.abstractfactory.pagamento.EmissorRecibo;
import br.com.joaoexercicios.model.Pedido;

public class ReciboPix implements EmissorRecibo {

    @Override
    public String emitir(Pedido pedido) {
        return "Recibo PIX para "+pedido.getCliente();
    }
}
