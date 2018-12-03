package myUberMVC;

public class InvalidCommandException extends Exception {
	String command;
	public InvalidCommandException(String string) {
		this.command=string;
	}
}
