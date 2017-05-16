package br.com.remembr.bemDaora.exception;

public class SenhaExpiradaException extends RuntimeException {
	
	private static final long serialVersionUID = 864014375628967972L;

	public SenhaExpiradaException(String message) {
		super(message);
	}

	public SenhaExpiradaException(Throwable cause) {
		super(cause);
	}

	public SenhaExpiradaException(String message, Throwable cause) {
		super(message, cause);
	}
}