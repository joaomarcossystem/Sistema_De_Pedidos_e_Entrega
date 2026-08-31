package br.com.joaoexercicios.model;

public class Pedido {

    private int numero;
    private String cliente;
    private String endereco;
    private double valor;

    public Pedido(int numero, String cliente, String endereco, double valor) {
        setNumero(numero);
        setCliente(cliente);
        setEndereco(endereco);
        setValor(valor);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero<=0){
            throw new IllegalArgumentException("Número inválido");
        }
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if(cliente==null || "".equals(cliente)){
            throw new IllegalArgumentException("Cliente inválido.");
        }
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco==null || "".equals(endereco)){
            throw new IllegalArgumentException("Endereço inválido");
        }
        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor<=0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.valor = valor;
    }
}
