package br.com.joaoexercicios.abstractfactory.pagamento;

import br.com.joaoexercicios.model.Pedido;

public interface ValidadorPagamento {

    public boolean validar(Pedido pedido);

}
