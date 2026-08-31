package br.com.joaoexercicios.factorymethod.entrega;

import br.com.joaoexercicios.model.Pedido;

public interface Entrega {
    public int calcularPrazoEmDias();
    public void realizarEntrega(Pedido pedido);

}
