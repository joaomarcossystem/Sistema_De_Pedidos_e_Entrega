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
 * Essa é a classe principal, a main, a interface que o usuário vê, utiliza e interage
 * Classe responsável por executar a aplicação e demonstrar
 * o funcionamento dos padrões Abstract Factory e Factory Method.
 */
public class Aplicacao {

    public static void main(String[] args) {

        /*
         * Criação do pedido que será utilizado nos diferentes
         * exemplos de pagamento e entrega.
         */
        Pedido pedido = new Pedido(
                1,
                "João",
                "Rua das Flores, 100",
                100.00
        );

        System.out.println("==============================================");
        System.out.println("       SISTEMA DE PEDIDOS E ENTREGAS");
        System.out.println("==============================================");

        System.out.println("\nPedido criado:");
        System.out.println("Número: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Endereço: " + pedido.getEndereco());
        System.out.println("Valor: R$ " + pedido.getValor());


        // =========================================================
        // ABSTRACT FACTORY - PAGAMENTO PIX
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       PAGAMENTO COM PIX");
        System.out.println("==============================================");

        System.out.println("Criando família de produtos para pagamento PIX...");

        PagamentoAbstractFactory pixFactory = new PixAbstractFactory();

        ServicoPagamento servicoPagamentoPix = new ServicoPagamento(pixFactory);

        System.out.println("Validando pagamento PIX...");

        String reciboPix = servicoPagamentoPix.processar(pedido);

        System.out.println("Pagamento PIX validado com sucesso!");
        System.out.println(reciboPix);


        // =========================================================
        // FACTORY METHOD - ENTREGA POR MOTO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       ENTREGA POR MOTO");
        System.out.println("==============================================");

        System.out.println("Criando fábrica de entrega por moto...");

        CentralEntrega entregaMoto = new CentralEntregaMotoFactory();

        System.out.println("Processando entrega...");

        entregaMoto.processarPedido(pedido);


        // =========================================================
        // ABSTRACT FACTORY - PAGAMENTO CARTÃO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       PAGAMENTO COM CARTÃO");
        System.out.println("==============================================");

        System.out.println("Criando família de produtos para pagamento com cartão...");

        PagamentoAbstractFactory cartaoFactory = new CartaoAbstractFactory();

        ServicoPagamento servicoPagamentoCartao = new ServicoPagamento(cartaoFactory);

        System.out.println("Validando pagamento com cartão...");

        String reciboCartao = servicoPagamentoCartao.processar(pedido);

        System.out.println("Pagamento com cartão validado com sucesso!");
        System.out.println(reciboCartao);


        // =========================================================
        // FACTORY METHOD - ENTREGA POR BICICLETA
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       ENTREGA POR BICICLETA");
        System.out.println("==============================================");

        System.out.println("Criando fábrica de entrega por bicicleta...");

        CentralEntrega entregaBicicleta = new CentralEntregaBicicletaFactory();

        System.out.println("Processando entrega...");

        entregaBicicleta.processarPedido(pedido);


        // =========================================================
        // ABSTRACT FACTORY - PAGAMENTO BOLETO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       PAGAMENTO COM BOLETO");
        System.out.println("==============================================");

        System.out.println("Criando família de produtos para pagamento com boleto...");

        PagamentoAbstractFactory boletoFactory = new BoletoAbstractFactory();

        ServicoPagamento servicoPagamentoBoleto = new ServicoPagamento(boletoFactory);

        System.out.println("Validando pagamento com boleto...");

        String reciboBoleto =
                servicoPagamentoBoleto.processar(pedido);

        System.out.println("Pagamento com boleto validado com sucesso!");
        System.out.println(reciboBoleto);


        // =========================================================
        // FACTORY METHOD - RETIRADA NO ESTABELECIMENTO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       RETIRADA NO ESTABELECIMENTO");
        System.out.println("==============================================");

        System.out.println("Criando fábrica de retirada...");

        CentralEntrega entregaRetirada = new CentralEntregaRetiradaFactory();

        System.out.println("Processando retirada...");

        entregaRetirada.processarPedido(pedido);


        // =========================================================
        // FINALIZAÇÃO
        // =========================================================

        System.out.println("\n==============================================");
        System.out.println("       FIM");
        System.out.println("==============================================");

        System.out.println("Todos os fluxos foram executados com sucesso.");
    }
}