package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.ITributavel;
import br.ufrn.imd.modelo.Pessoa;

public class GeradorImpostoRenda {
    private double totalTributo;

    public double calculaValorTotalTributo(Pessoa p) {
        totalTributo = 0;

        // Verifica se a pessoa possui conta corrente e/ou seguro vida
        ITributavel conta = p.getConta();
        ITributavel seguro = p.getSeguro();

        if (conta != null) {
            totalTributo += conta.calcularTributos();
        }
        if (seguro != null) {
            totalTributo += seguro.calcularTributos();
        }

        totalTributo += p.calcularImpostoSalario(); // Adiciona o imposto sobre o salário da pessoa

        return totalTributo;
    }
}
