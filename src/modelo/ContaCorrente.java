package modelo;

public class ContaCorrente implements ITributavel{
    private String agencia;
    private String numero;
    private double saldo;


    public ContaCorrente() {

    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean transferir(double valor, ContaCorrente cc) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            cc.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso para a conta " + cc.getNumero());
            return true;
        } else {
            System.out.println("Saldo insuficiente para transferência de R$ " + valor);
            return false;
        }
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia){
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero){
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double calcularTributos() {
        return saldo * 0.0038; // 0,38% do valor do saldo
    }
}
