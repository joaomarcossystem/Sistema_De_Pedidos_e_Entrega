package br.com.joaoexercicios.factorymethod.entrega.bicicleta;

import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.Entrega;

public class CentralEntregaBicicletaFactory extends CentralEntrega {
    @Override
    protected Entrega criarEntrega() {
        return new EntregaBicicleta();
    }
}
