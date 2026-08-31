package br.com.joaoexercicios.abstractfactory.pagamento;

/**
 * Define a fábrica abstrata responsável pela criação
 * dos produtos relacionados ao pagamento.
 *
 * Cada implementação dessa interface representa uma forma
 * de pagamento e cria seu respectivo validador e emissor de recibo.
 */

public interface PagamentoAbstractFactory {

    public ValidadorPagamento criarValidadorPagamento();
    public EmissorRecibo criarEmissorRecibo();

}
