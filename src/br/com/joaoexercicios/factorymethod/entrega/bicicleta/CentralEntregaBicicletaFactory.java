package br.com.joaoexercicios.factorymethod.entrega.bicicleta;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

/**
 * Fábrica concreta responsável pela criação de entregas por bicicleta.
 *
 * Implementa o Factory Method definido por CentralEntrega,
 * retornando uma instância de EntregaBicicleta.
 */

public class CentralEntregaBicicletaFactory extends CentralEntrega {
    @Override
    protected Entrega criarEntrega() {
        return new EntregaBicicleta();
    }
}
