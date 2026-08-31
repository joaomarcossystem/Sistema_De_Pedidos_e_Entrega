package br.com.joaoexercicios.factorymethod.entrega.retirada;

import br.com.joaoexercicios.factorymethod.entrega.Entrega;
import br.com.joaoexercicios.model.Pedido;

/**
 * Representa uma entrega realizada por meio de retirada
 * do pedido no estabelecimento.
 *
 * Define o comportamento específico da retirada,
 * disponibilizando o pedido para o cliente no estabelecimento.
 */

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
