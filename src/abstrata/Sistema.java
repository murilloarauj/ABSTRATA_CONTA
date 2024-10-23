package abstrata;

	public class Sistema {
	    public static void main(String[] args) {
	    	// Inicializa uma conta corrente com saldo inicial de 2500 e limite de 5000
	        ContaCorrente contaC = new ContaCorrente(2500f, 5000f);
	        // Inicializa uma conta poupança com saldo inicial de 2000
	        ContaPoupanca contaP = new ContaPoupanca(2000f);
	        
	        // Efetua um saque de 300 na conta corrente
	        contaC.saque(300);
	        // Efetua um depósito de 450 na conta corrente
	        contaC.deposito(450);
	        // Realiza a consulta do saldo atual da conta corrente
	        contaC.consulta();
	        
	        // Exibe uma linha de separação entre as operações realizadas
	        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	        System.out.println("~~~ Fim das Transações feitas na Conta Corrente ~~~");
	        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	        
	        // Efetua um saque de 700 na conta poupança
	        contaP.saque(700);
	        // Efetua um depósito de 500 na conta poupança
	        contaP.deposito(500);
	        // Realiza a consulta do saldo atual da conta poupança
	        contaP.consulta();
	    }
	}