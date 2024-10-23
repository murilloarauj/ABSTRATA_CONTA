package abstrata;

	
	public class ContaCorrente extends ContaBancaria {
	    protected String tipodaConta; // Define o tipo da conta
	    protected float saldoPresente;
	    protected float limiteDisponivel;
	    protected float taxadeSaque = 0.10f;
	    protected float taxadeDeposito = 0.03f;
	    protected float taxadeConsulta = 0.02f;

	    // Construtor que atribui o tipo de conta e inicializa saldo e limite
	    public ContaCorrente(float saldoPresente, float limiteDisponivel) {
	        this.tipodaConta = "Corrente";  // Define o tipo da conta no construtor
	        this.saldoPresente = saldoPresente;
	        this.limiteDisponivel = limiteDisponivel;
	    }

	    // Método que retorna o tipo de conta
	    public String getTipodaConta() {
	        return tipodaConta;  // Retorna o tipo da conta
	    }

	    public float getSaldoPresente() {
	        return saldoPresente;
	    }

	    public void setSaldoPresente(float saldoPresente) {
	        this.saldoPresente = saldoPresente;
	    }

	    public float getLimiteDisponivel() {
	        return limiteDisponivel;
	    }

	    public void setLimiteDisponivel(float limiteDisponivel) {
	        this.limiteDisponivel = limiteDisponivel;
	    }

	    public float getTaxadeSaque() {
	        return taxadeSaque;
	    }

	    public void setTaxadeSaque(float taxadeSaque) {
	        this.taxadeSaque = taxadeSaque;
	    }

	    public float getTaxadeDeposito() {
	        return taxadeDeposito;
	    }

	    public void setTaxadeDeposito(float taxadeDeposito) {
	        this.taxadeDeposito = taxadeDeposito;
	    }

	    public float getTaxadeConsulta() {
	        return taxadeConsulta;
	    }

	    public void setTaxadeConsulta(float taxadeConsulta) {
	        this.taxadeConsulta = taxadeConsulta;
	    }

	    // Aplica a taxa sobre um valor
	    private float aplicaTaxa(float valor, float taxa) {
	        return valor * taxa;
	    }

	    // Calcula o saque com a taxa incluída
	    void calculodoSaque(float valordoSaque) {
	        float valorTaxa = aplicaTaxa(valordoSaque, taxadeSaque);
	        float valorTotalSaque = valordoSaque + valorTaxa;

	        // Verifica se o valor total do saque ultrapassa o saldo disponível mais o limite
	        if (valorTotalSaque > saldoPresente + limiteDisponivel) {
	            throw new IllegalArgumentException("O valor do saque ultrapassou o limite disponível.");
	        }

	        saldoPresente -= valorTotalSaque;
	        System.out.println("Saque realizado foi no valor de: " + valordoSaque +
	                "\nTaxa aplicada no saque: " + taxadeSaque * 100 + "%" +
	                "\nValor da taxa: " + valorTaxa);
	    }

	    // Calcula o depósito com a taxa incluída
	    void calculodoDeposito(float valordoDeposito) {
	        if (valordoDeposito <= 0) {
	            throw new IllegalArgumentException("O valor do depósito deve exceder zero.");
	        }

	        float valorTaxaDeposito = aplicaTaxa(valordoDeposito, taxadeDeposito);
	        float valorFinalDeposito = valordoDeposito - valorTaxaDeposito;

	        saldoPresente += valorFinalDeposito;
	        System.out.println("Depósito realizado foi no valor de: " + valordoDeposito +
	                "\nTaxa aplicada no depósito: " + taxadeDeposito * 100 + "%" +
	                "\nValor da taxa: " + valorTaxaDeposito);
	    }

	    @Override
	    void saque(float valordoSaque) {
	        calculodoSaque(valordoSaque);
	        System.out.println("Saldo atualizado e disponivel na conta: " + saldoPresente + "\n");
	    }

	    @Override
	    void deposito(float valordoDeposito) {
	        calculodoDeposito(valordoDeposito);
	        System.out.println("Saldo atualizado e disponivel na conta: " + saldoPresente + "\n");
	    }

	    // Realiza a consulta de saldo com aplicação de taxa
	    @Override
	    void consulta() {
	        float valorTaxaConsulta = aplicaTaxa(saldoPresente, taxadeConsulta);
	        saldoPresente -= valorTaxaConsulta;

	        System.out.println("Consulta de saldo feita com sucesso." +
	                "\nAtualizaçao de saldo após a cobrança de taxa: " + saldoPresente +
	                "\nTaxa aplicada na consulta de saldo: " + taxadeConsulta * 100 + "%" +
	                "\nValor da taxa: " + valorTaxaConsulta);
	    }
	}