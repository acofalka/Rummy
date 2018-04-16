package exceptions;

public class NotEnoughCardsException extends RuntimeException {
	public NotEnoughCardsException() { super(); }
	public NotEnoughCardsException(String message) { super(message); }
	public NotEnoughCardsException(String message, Throwable cause) { super(message, cause); }
	public NotEnoughCardsException(Throwable cause) { super(cause); }
}
