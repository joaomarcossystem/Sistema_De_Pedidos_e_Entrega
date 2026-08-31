package br.com.joaoexercicios.factorymethod.entrega.moto;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

public class CentralEntregaMotoFactory extends CentralEntrega {
    @Override
    protected Entrega criarEntrega() {
        return new EntregaMoto();
    }
}
