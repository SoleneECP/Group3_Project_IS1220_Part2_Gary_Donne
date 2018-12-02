package myUberUsers;

public class MessageBox {
	
	/**
	 * A message displaying on the message box to the customer
	 */
	public String message;
	
	public MessageBox(String message) {
		this.message = message;
	}
	
	/**
	 * Add a message to display on the message box to the customer
	 * @param message the message to display 
	 */
	public static void add (String message) {
		System.out.println(message);
	}
	

}
