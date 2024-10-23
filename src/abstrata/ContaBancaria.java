package abstrata;

	public abstract class ContaBancaria {
		
		abstract void saque(float valordoSaque);
		abstract void deposito(float valordeDeposito);
	    abstract void consulta();  
	}