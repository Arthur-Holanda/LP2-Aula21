package modelo;

public class Pessoa {
    private String nome;
    private double salario;
    private ContaCorrente conta;
    private SeguroVida seguro;


    public Pessoa() {
    }

    // Método para calcular o imposto sobre o salário
    public double calcularImpostoSalario() {
        return salario * 0.11; // 11% de imposto sobre o salário
    }

    // Métodos getters e setters para os atributos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public SeguroVida getSeguro() {
        return seguro;
    }

    public void setSeguro(SeguroVida seguro) {
        this.seguro = seguro;
    }
}
