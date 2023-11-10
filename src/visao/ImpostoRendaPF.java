package visao;

import controle.GeradorImpostoRenda;
import dao.PessoaDAO;
import modelo.ContaCorrente;
import modelo.Pessoa;
import modelo.SeguroVida;

public class ImpostoRendaPF {
    /*
    public static void main(String[] args) {
        // Instanciando objetos Pessoa
        Pessoa pessoa1 = criarPessoaExemplo("João", 5000, 10000, 20000);
        Pessoa pessoa2 = criarPessoaExemplo("Maria", 6000, 15000, 25000);
        Pessoa pessoa3 = criarPessoaExemplo("Pedro", 7000, 12000, 18000);

        // Instanciando PessoaDAO
        PessoaDAO pessoaDAO = new PessoaDAO();

        // Persistindo objetos Pessoa na PessoaDAO
        pessoaDAO.cadastraPessoa(pessoa1);
        pessoaDAO.cadastraPessoa(pessoa2);
        pessoaDAO.cadastraPessoa(pessoa3);

        // Calculando e imprimindo os tributos de cada pessoa
        GeradorImpostoRenda geradorImpostoRenda = new GeradorImpostoRenda();
        System.out.println("Tributos a serem recolhidos por cada pessoa:");
        System.out.println("Pessoa 1: R$" + geradorImpostoRenda.calculaValorTotalTributo(pessoa1));
        System.out.println("Pessoa 2: R$" + geradorImpostoRenda.calculaValorTotalTributo(pessoa2));
        System.out.println("Pessoa 3: R$" + geradorImpostoRenda.calculaValorTotalTributo(pessoa3));
    }

    // Método auxiliar para criar pessoa com exemplo de conta corrente e seguro vida
    private static Pessoa criarPessoaExemplo(String nome, double salario, double saldoConta, double valorSeguro) {
        ContaCorrente conta = new ContaCorrente("001", "12345", saldoConta);
        SeguroVida seguro = new SeguroVida(1, "Familiar", valorSeguro, 31.50);
        return new Pessoa(nome, salario, conta, seguro);
    }
    */

    public static void main(String[] args) {
        PessoaDAO daoP = new PessoaDAO();
        ContaCorrente cc1 = new ContaCorrente();
        cc1.setAgencia("1020-5");
        cc1.setNumero("100.231-1");
        cc1.setSaldo(0);
        SeguroVida sv1 = new SeguroVida();
        sv1.setNumero(1);
        sv1.setBeneficiado("Maria da Silva");
        sv1.setValor(10000);
        Pessoa p1 = new Pessoa();
        p1.setNome("Roberto Carlos");
        p1.setSalario(500.0);
        p1.setConta(cc1);
        p1.setSeguro(sv1);
        daoP.cadastraPessoa(p1);
        ContaCorrente cc2 = new ContaCorrente();
        cc2.setAgencia("2105-4");
        cc2.setNumero("123.564-9");
        cc2.setSaldo(0);
        SeguroVida sv2 = new SeguroVida();
        sv2.setNumero(2);
        sv2.setBeneficiado("João Maria");
        sv2.setValor(15000);
        Pessoa p2 = new Pessoa();
        p2.setNome("Dom Pedro");
        p2.setSalario(1000.0);
        p2.setConta(cc2);
        p2.setSeguro(sv2);
        daoP.cadastraPessoa(p2);
        ContaCorrente cc3 = new ContaCorrente();
        cc3.setAgencia("3565-4");
        cc3.setNumero("584.557-3");
        cc3.setSaldo(0);
        SeguroVida sv3 = new SeguroVida();
        sv3.setNumero(3);
        sv3.setBeneficiado("João do Patrocínio");
        sv3.setValor(16000);
        Pessoa p3 = new Pessoa();
        p3.setNome("Rui Barbosa");
        p3.setSalario(1500.50);
        p3.setConta(cc3);
        p3.setSeguro(sv3);
        daoP.cadastraPessoa(p3);
// Listar as Pessoas
        daoP.listaPessoas();
// Depósitos
        p1.getConta().depositar(200);
        p2.getConta().depositar(500);
        System.out.println();
// Saques
        p3.getConta().sacar(100);
        System.out.println();
// Transferências
        p2.getConta().transferir(300, cc3);
// Listar as Pessoas
        daoP.listaPessoas();
// Listar os impostos
        daoP.CalcularTributosPessoas();
// Listar o total de imposto e Pessoas associadas
        daoP.imprimeImpostoTotal();
    }
}

