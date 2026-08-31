    package br.com.joaoexercicios.factorymethod.entrega.bicicleta;

    import br.com.joaoexercicios.factorymethod.entrega.Entrega;
    import br.com.joaoexercicios.model.Pedido;

    /**
     * Representa uma entrega realizada por meio de uma bicicleta.
     *
     * Define o prazo e o comportamento específico da entrega
     * realizada por esse meio de transporte.
     */

    public class EntregaBicicleta implements Entrega {
        @Override
        public int calcularPrazoEmDias() {
            return 3;
        }

        @Override
        public void realizarEntrega(Pedido pedido) {
            System.out.println("Entrega do pedido "+pedido.getNumero()+ " realizada por bicicleta");
        }
    }
