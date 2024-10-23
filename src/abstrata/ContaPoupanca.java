package abstrata;

	public class ContaPoupanca extends ContaBancaria {
	    protected String tipodaConta;  // Armazena o tipo de conta
	    protected float saldopresente; // Valor do saldo atual
	    protected float taxadeSaque = 0.10f; // Percentual de taxa aplicado ao saque
	    protected float taxadeDeposito = 0.03f; // Percentual de taxa aplicado ao depósito
	    protected float taxadeConsulta = 0.02f; // Percentual de taxa aplicado à consulta

	    // Construtor que define o tipo de conta e o saldo inicial
	    public ContaPoupanca(float saldoInicial) {
	        this.tipodaConta = "Poupança"; // Define o tipo de conta
	        this.saldopresente = saldoInicial; // Inicializa o saldo
	    }

	 // Método para obter o tipo de conta
	    public String getTipoConta() {
	        return tipodaConta; // Retorna o tipo de conta
	    }

	    public float getSaldoPresente() {
	        return saldopresente; // Retorna o saldo atual
	    }

	    public void setSaldoPresente(float saldoPresente) {
	        this.saldopresente = saldoPresente; // Define um novo saldo
	    }

	    public float getTaxadeSaque() {
	        return taxadeSaque; // Retorna a taxa do saque
	    }

	    public void setTaxadeSaque(float taxadeSaque) {
	        this.taxadeSaque = taxadeSaque; // Altera a taxa de saque
	    }

	    public float getTaxadeDeposito() {
	        return taxadeDeposito; // Retorna a taxa de depósito
	    }

	    public void setTaxadeDeposito(float taxadeDeposito) {
	        this.taxadeDeposito = taxadeDeposito; // Altera a taxa de depósito
	    }

	    public float getTaxadeConsulta() {
	        return taxadeConsulta; // Retorna a taxa de consulta
	    }

	    public void setTaxadeConsulta(float taxadeConsulta) {
	        this.taxadeConsulta = taxadeConsulta; // Altera a taxa de consulta
	    }

	    // Aplica a taxa sobre um determinado valor
	    private float aplicaTaxa(float valor, float taxa) {
	        return valor * taxa; // Calcula o valor da taxa
	    }

	    // Realiza o cálculo e verificação do saque com a aplicação da taxa
	    void calculodoSaque(float valorSaque) {
	        float valorTaxa = aplicaTaxa(valorSaque, taxadeSaque); // Calcula o valor da taxa de saque
	        // Verifica se o valor solicitado para saque é maior que o saldo disponível
	        if (valorSaque > saldopresente) {
	            throw new IllegalArgumentException("O valor do saque ultrapassou o valor do saldo disponível.");
	        }

	        saldopresente -= (valorSaque + valorTaxa); // Deduz o valor do saque e da taxa do saldo
	        System.out.println("Saque realizado foi no valor de: " + valorSaque +
	                "\nTaxa aplicada no saque: " + taxadeSaque * 100 + "%" +
	                "\nValor da taxa: " + valorTaxa);
	    }

	    // Realiza o cálculo do depósito com a aplicação da taxa
	    void calculodoDeposito(float valorDeposito) {
	        if (valorDeposito <= 0) {
	            throw new IllegalArgumentException("O valor do depósitado deve exceder zero.");
	        }

	        float valorTaxaDeposito = aplicaTaxa(valorDeposito, taxadeDeposito); // Calcula o valor da taxa de depósito
	        float valorFinalDeposito = valorDeposito - valorTaxaDeposito; // Valor final após a dedução da taxa

	        saldopresente += valorFinalDeposito; // Atualiza o saldo
	        System.out.println("Depósito realizado no foi valor de: " + valorDeposito +
	                "\nTaxa aplicada no depósito: " + taxadeDeposito * 100 + "%" +
	                "\nValor da taxa: " + valorTaxaDeposito);
	    }

	    @Override
	    void saque(float valorSaque) {
	        calculodoSaque(valorSaque);  // Realiza o cálculo do saque
	        System.out.println("Saldo atualizado e disponivel na conta: " + saldopresente + "\n");
	    }

	    @Override
	    void deposito(float valorDeposito) {
	        calculodoDeposito(valorDeposito); // Realiza o cálculo do depósito
	        System.out.println("Saldo atualizado e disponivel na conta: " + saldopresente + "\n");
	    }

	    @Override
	    void consulta() {
	        float valorTaxaConsulta = aplicaTaxa(saldopresente, taxadeConsulta);  // Calcula a taxa sobre o saldo
	        saldopresente -= valorTaxaConsulta; // Atualiza o saldo após a cobrança da taxa de consulta

	        System.out.println("Consulta de saldo feita com sucesso." +
	                "\nAtualizaçao de saldo após a cobrança de taxa: " + saldopresente +
	                "\nTaxa aplicada na consulta de saldo: " + taxadeConsulta * 100 + "%" +
	                "\nValor da taxa: " + valorTaxaConsulta);
	    }
	}