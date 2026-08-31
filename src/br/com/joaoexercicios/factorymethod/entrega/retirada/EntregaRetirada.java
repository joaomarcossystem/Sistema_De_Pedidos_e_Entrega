package br.com.joaoexercicios.factorymethod.entrega.retirada;

import br.com.joaoexercicios.factorymethod.entrega.Entrega;
import br.com.joaoexercicios.model.Pedido;

public class EntregaRetirada implements Entrega {
    @Override
    public int calcularPrazoEmDias() {
        return 0;
    }

    @Override
    public void realizarEntrega(Pedido pedido) {
        System.out.println("Pedido: "+pedido.getNumero()+ " disponível para retirada.");
    }
}
