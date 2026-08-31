package br.com.joaoexercicios.abstractfactory.pagamento;

import br.com.joaoexercicios.model.Pedido;

public interface EmissorRecibo {

    public String emitir(Pedido pedido);

}
