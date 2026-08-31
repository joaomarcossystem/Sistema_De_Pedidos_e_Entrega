package br.com.joaoexercicios.abstractfactory.pagamento;

public interface PagamentoAbstractFactory {

    public ValidadorPagamento criarValidadorPagamento();
    public EmissorRecibo criarEmissorRecibo();

}
