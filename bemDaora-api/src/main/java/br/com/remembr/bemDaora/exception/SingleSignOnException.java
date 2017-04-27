package br.com.remembr.bemDaora.exception;

public class SingleSignOnException extends RuntimeException {
	
	private static final long serialVersionUID = 4231892320546089172L;

	public SingleSignOnException(String message) {
		super(message);
	}

	public SingleSignOnException(Throwable cause) {
		super(cause);
	}

	public SingleSignOnException(String message, Throwable cause) {
		super(message, cause);
	}

}