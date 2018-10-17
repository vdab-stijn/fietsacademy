package be.vdab.academy.exceptions;

public class TeacherNotFoundException extends RuntimeException {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	public TeacherNotFoundException() { super(); }
	public TeacherNotFoundException(final String message) { super(message); }
}
