package br.com.joaoexercicios.factorymethod.entrega.moto;

import br.com.joaoexercicios.factorymethod.entrega.Entrega;
import br.com.joaoexercicios.model.Pedido;

public class EntregaMoto implements Entrega {
    @Override
    public int calcularPrazoEmDias() {
        return 2;
    }

    @Override
    public void realizarEntrega(Pedido pedido) {
        System.out.println("Entrega do pedido "+pedido.getNumero()+ " realizada por moto");
    }
}
