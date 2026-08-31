    package br.com.joaoexercicios.factorymethod.entrega.bicicleta;

    import br.com.joaoexercicios.factorymethod.entrega.Entrega;
    import br.com.joaoexercicios.model.Pedido;

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
