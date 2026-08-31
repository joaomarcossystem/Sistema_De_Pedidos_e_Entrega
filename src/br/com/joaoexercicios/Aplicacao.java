package br.com.joaoexercicios;

import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.boleto.BoletoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.cartao.CartaoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.pix.PixAbstractFactory;
import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.bicicleta.CentralEntregaBicicletaFactory;
import br.com.joaoexercicios.factorymethod.entrega.moto.CentralEntregaMotoFactory;
import br.com.joaoexercicios.factorymethod.entrega.retirada.CentralEntregaRetiradaFactory;
import br.com.joaoexercicios.model.Pedido;
import br.com.joaoexercicios.service.ServicoPagamento;

/**
 *  Essa é a classe principal, a main, a interface que o usuário vê, utiliza e interage
 * Classe responsável por executar a aplicação e demonstrar
 * o funcionamento dos padrões Abstract Factory e Factory Method.
 */
public class Aplicacao {

    public static void main(String[] args) {

        // =========================================================
        // CRIAÇÃO DOS PEDIDOS
        // =========================================================

        /*
         * São criados dois pedidos diferentes para demonstrar
         * os diferentes fluxos de pagamento e entrega.
         */
        Pedido pedido1 = new Pedido(
                1,
                "João",
                "Rua das Flores, 100",
                100.00
        );

        Pedido pedido2 = new Pedido(
                2,
                "Maria",
                "Avenida Brasil, 200",
                50.00
        );

        System.out.println("==============================================");
        System.out.println("       SISTEMA DE PEDIDOS E ENTREGAS");
        System.out.println("==============================================");

        System.out.println("\nPedidos criados:");

        System.out.println("\nPedido 1:");
        System.out.println("Número: " + pedido1.getNumero());
        System.out.println("Cliente: " + pedido1.getCliente());
        System.out.println("Endereço: " + pedido1.getEndereco());
        System.out.println("Valor: R$ " + pedido1.getValor());

        System.out.println("\nPedido 2:");
        System.out.println("Número: " + pedido2.getNumero());
        System.out.println("Cliente: " + pedido2.getCliente());
        System.out.println("Endereço: " + pedido2.getEndereco());
        System.out.println("Valor: R$ " + pedido2.getValor());


        // =========================================================
        // PEDIDO 1 - PIX + MOTO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       PEDIDO 1 - PIX + MOTO");
        System.out.println("==============================================");

        System.out.println("\n--- ABSTRACT FACTORY: PAGAMENTO PIX ---");

        System.out.println("Criando família de produtos para pagamento PIX...");

        PagamentoAbstractFactory pixFactory = new PixAbstractFactory();

        ServicoPagamento servicoPagamentoPix = new ServicoPagamento(pixFactory);

        System.out.println("Validando pagamento PIX...");

        String reciboPix =
                servicoPagamentoPix.processar(pedido1);

        System.out.println("Pagamento PIX validado com sucesso!");
        System.out.println(reciboPix);


        System.out.println("\n--- FACTORY METHOD: ENTREGA POR MOTO ---");

        System.out.println("Criando fábrica de entrega por moto...");

        CentralEntrega entregaMoto = new CentralEntregaMotoFactory();

        System.out.println("Processando entrega...");

        entregaMoto.processarPedido(pedido1);


        // =========================================================
        // PEDIDO 2 - CARTÃO + BICICLETA
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       PEDIDO 2 - CARTÃO + BICICLETA");
        System.out.println("==============================================");

        System.out.println("\n--- ABSTRACT FACTORY: PAGAMENTO CARTÃO ---");

        System.out.println("Criando família de produtos para pagamento com cartão...");

        PagamentoAbstractFactory cartaoFactory = new CartaoAbstractFactory();

        ServicoPagamento servicoPagamentoCartao = new ServicoPagamento(cartaoFactory);

        System.out.println("Validando pagamento com cartão...");

        String reciboCartao =
                servicoPagamentoCartao.processar(pedido2);

        System.out.println("Pagamento com cartão validado com sucesso!");
        System.out.println(reciboCartao);


        System.out.println("\n--- FACTORY METHOD: ENTREGA POR BICICLETA ---");

        System.out.println("Criando fábrica de entrega por bicicleta...");

        CentralEntrega entregaBicicleta = new CentralEntregaBicicletaFactory();

        System.out.println("Processando entrega...");

        entregaBicicleta.processarPedido(pedido2);


        // =========================================================
        // EXTENSÃO - BOLETO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       EXTENSÃO - PAGAMENTO POR BOLETO");
        System.out.println("==============================================");

        System.out.println("Criando família de produtos para pagamento com boleto...");

        PagamentoAbstractFactory boletoFactory = new BoletoAbstractFactory();

        ServicoPagamento servicoPagamentoBoleto = new ServicoPagamento(boletoFactory);

        System.out.println("Validando pagamento com boleto...");

        String reciboBoleto =
                servicoPagamentoBoleto.processar(pedido1);

        System.out.println("Pagamento com boleto validado com sucesso!");
        System.out.println(reciboBoleto);


        // =========================================================
        // EXTENSÃO - RETIRADA
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       EXTENSÃO - RETIRADA");
        System.out.println("==============================================");

        System.out.println("Criando fábrica de retirada...");

        CentralEntrega entregaRetirada = new CentralEntregaRetiradaFactory();

        System.out.println("Processando retirada...");

        entregaRetirada.processarPedido(pedido2);


        // =========================================================
        // FINALIZAÇÃO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       FIM DA DEMONSTRAÇÃO");
        System.out.println("==============================================");

        System.out.println("Todos os fluxos foram executados com sucesso.");
    }
}