package exceptions;

public class JokerSwapException extends Exception {
	public JokerSwapException() { super(); }
	public JokerSwapException(String message) { super(message); }
	public JokerSwapException(String message, Throwable cause) { super(message, cause); }
	public JokerSwapException(Throwable cause) { super(cause); }
}
