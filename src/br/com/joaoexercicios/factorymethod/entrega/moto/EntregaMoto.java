package br.com.joaoexercicios.factorymethod.entrega.moto;

import br.com.joaoexercicios.factorymethod.entrega.Entrega;
import br.com.joaoexercicios.model.Pedido;

/**
 * Representa uma entrega realizada por meio de uma moto.
 *
 * Define o prazo e o comportamento específico da entrega
 * realizada por esse meio de transporte.
 */

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
