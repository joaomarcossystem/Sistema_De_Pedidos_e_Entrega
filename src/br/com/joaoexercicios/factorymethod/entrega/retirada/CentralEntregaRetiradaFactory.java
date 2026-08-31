package br.com.joaoexercicios.factorymethod.entrega.retirada;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

public class CentralEntregaRetiradaFactory extends CentralEntrega {

    @Override
    protected Entrega criarEntrega() {
        return new EntregaRetirada();
    }
}
