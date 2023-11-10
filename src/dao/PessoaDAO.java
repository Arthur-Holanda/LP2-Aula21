package dao;

import modelo.Pessoa;
import java.util.ArrayList;

public class PessoaDAO {
    private ArrayList<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastraPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public void listaPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
        }
    }

    public double CalcularTributosPessoas() {
        double totalTributos = 0;
        for (Pessoa pessoa : pessoas) {
            totalTributos += pessoa.calcularImpostoSalario();
            if (pessoa.getConta() != null) {
                totalTributos += pessoa.getConta().calcularTributos();
            }
            if (pessoa.getSeguro() != null) {
                totalTributos += pessoa.getSeguro().calcularTributos();
            }
        }
        return totalTributos;
    }

    public void imprimeImpostoTotal() {
        double maiorImposto = 0;
        String nomeMaiorImposto = "";
        double maiorValorSeguro = 0;
        String beneficiadoMaiorSeguro = "";

        for (Pessoa pessoa : pessoas) {
            if (pessoa.calcularImpostoSalario() > maiorImposto) {
                maiorImposto = pessoa.calcularImpostoSalario();
                nomeMaiorImposto = pessoa.getNome();
            }
            if (pessoa.getSeguro() != null && pessoa.getSeguro().getValor() > maiorValorSeguro) {
                maiorValorSeguro = pessoa.getSeguro().getValor();
                beneficiadoMaiorSeguro = pessoa.getSeguro().getBeneficiado();
            }
        }

        System.out.println("Valor total de imposto a ser recolhido: R$" + CalcularTributosPessoas());
        System.out.println("Pessoa que pagará o maior imposto: " + nomeMaiorImposto);
        System.out.println("Beneficiado com o maior valor de seguro: " + beneficiadoMaiorSeguro);
    }
}
