package exceptions;

public class IndexOutOfRangeException extends RuntimeException {
	public IndexOutOfRangeException() { super(); }
	public IndexOutOfRangeException(String message) { super(message); }
	public IndexOutOfRangeException(String message, Throwable cause) { super(message, cause); }
	public IndexOutOfRangeException(Throwable cause) { super(cause); }
}
