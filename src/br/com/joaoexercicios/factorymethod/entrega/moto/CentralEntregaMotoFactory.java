package br.com.joaoexercicios.factorymethod.entrega.moto;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

/**
 * Fábrica concreta responsável pela criação de entregas por moto.
 *
 * Implementa o Factory Method definido por CentralEntrega,
 * retornando uma instância de EntregaMoto.
 */

public class CentralEntregaMotoFactory extends CentralEntrega {
    @Override
    protected Entrega criarEntrega() {
        return new EntregaMoto();
    }
}
