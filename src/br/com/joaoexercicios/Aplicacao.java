package br.com.joaoexercicios;

import br.com.joaoexercicios.abstractfactory.pagamento.PagamentoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.cartao.CartaoAbstractFactory;
import br.com.joaoexercicios.abstractfactory.pagamento.pix.PixAbstractFactory;
import br.com.joaoexercicios.factorymethod.entrega.CentralEntrega;
import br.com.joaoexercicios.factorymethod.entrega.bicicleta.CentralEntregaBicicletaFactory;
import br.com.joaoexercicios.factorymethod.entrega.moto.CentralEntregaMotoFactory;
import br.com.joaoexercicios.factorymethod.entrega.retirada.CentralEntregaRetiradaFactory;
import br.com.joaoexercicios.model.Pedido;
import br.com.joaoexercicios.service.ServicoPagamento;

public class Aplicacao {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(
                1,
                "João",
                "Rua A",
                100
        );

        // =========================
        // PIX + MOTO
        // =========================

        PagamentoAbstractFactory pixFactory = new PixAbstractFactory();

        ServicoPagamento servicoPagamentoPix =
                new ServicoPagamento(pixFactory);

        String reciboPix = servicoPagamentoPix.processar(pedido);

        System.out.println(reciboPix);

        CentralEntrega entregaMoto =
                new CentralEntregaMotoFactory();

        entregaMoto.processarPedido(pedido);


        // =========================
        // CARTÃO + BICICLETA
        // =========================

        PagamentoAbstractFactory cartaoFactory =
                new CartaoAbstractFactory();

        ServicoPagamento servicoPagamentoCartao =
                new ServicoPagamento(cartaoFactory);

        String reciboCartao =
                servicoPagamentoCartao.processar(pedido);

        System.out.println(reciboCartao);

        CentralEntrega entregaBicicleta =
                new CentralEntregaBicicletaFactory();

        entregaBicicleta.processarPedido(pedido);


        // =========================
        // RETIRADA
        // =========================

        CentralEntrega entregaRetirada =
                new CentralEntregaRetiradaFactory();

        entregaRetirada.processarPedido(pedido);
    }
}
