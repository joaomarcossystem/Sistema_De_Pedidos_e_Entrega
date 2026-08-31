package br.com.joaoexercicios.factorymethod.entrega.retirada;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

/**
 * Fábrica concreta responsável pela criação de entregas
 * por retirada no estabelecimento.
 *
 * Implementa o Factory Method definido por CentralEntrega,
 * retornando uma instância de EntregaRetirada.
 */

public class CentralEntregaRetiradaFactory extends CentralEntrega {

    @Override
    protected Entrega criarEntrega() {
        return new EntregaRetirada();
    }
}
