package myUberMVC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import myUberUsers.CarTypeDoesntExistException;

/**
 * The view of the MVC Pattern for the MyUber System
 *
 */
public class MyUberView {
	/**
	 * A queue holding references to the different message box of the Customer, that are waiting answer of the user through the CLUI 
	 */
	Queue<List<String>> messageAwaitingAnswer=new LinkedList<List<String>>();
	
	/**
	 * A reference to the pattern's Controller
	 */
	MyUberController myUberController;
	
	/**
	 * A request by either the controller or the model to display something to the user
	 * @param message The message to be display
	 */
	public void display(String message) {
		
	}
	public void displayLastMessage() {
		if(messageAwaitingAnswer.isEmpty()) {
			System.out.println("Please enter a command");
		}
		else {
			messageAwaitingAnswer.peek().get(messageAwaitingAnswer.peek().size()-1);
		}
	}
	
	public void processInput(String string) throws IndexOutOfBoundsException,InvalidCommandException,NumberFormatException,FileNotFoundException,CarTypeDoesntExistException {
		if(messageAwaitingAnswer.isEmpty()) {
			myUberController.enterCommand(string);
		}
		else {
			List<String> messageBox= messageAwaitingAnswer.poll();
			try {
				synchronized(messageBox) {
					messageBox.add(string);
					messageBox.notify();
				}
			}
			catch(NumberFormatException e) {
				System.out.println("the mark given is not a correct mark");
				synchronized(messageBox) {
					messageBox.remove(messageBox.size()-1);
					messageAwaitingAnswer.add(messageBox);
				}
			}
			
			catch(IllegalArgumentException e) {
				System.out.println("the rideType entered does not exist");
				messageBox.remove(messageBox.size()-1);
				messageAwaitingAnswer.add(messageBox);
			}
		}
	}
	
	public void launchInterface() {
		String input;
		Scanner sc=new Scanner(System.in);
		while(true) {
			try {
				displayLastMessage();
				input=sc.nextLine();
				if(input.equalsIgnoreCase("stop")) {
					break;
				}
				processInput(input);
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Try again, not enough arguments were entered");
			}
			catch(InvalidCommandException e) {
				System.out.println("The command" + e.command + "you entered does not exist, please watch the case");
			}
			catch(NumberFormatException e) {
				System.out.println("An parameter is not a number as expected");
			}
			catch(FileNotFoundException e) {
				System.out.println("The File name you entered could not be found");
			}
			catch(CarTypeDoesntExistException e) {
				System.out.println("The Car Type"+ e.carType + "doesnt exist");
			}
			catch(IllegalArgumentException e) {
				System.out.println("The rideType entered doesn't exists");
			}
		}
		sc.close();
	}
	public void displayDrivers(String string) {
		// TODO Auto-generated method stub
		
	}
	public void displayCustomers(String string) {
		// TODO Auto-generated method stub
		
	}
	public void displayTotalCashed(MyUberModel myUberModel) {
		// TODO Auto-generated method stub
		
	}
	public void displayCars() {
		// TODO Auto-generated method stub
		
	}
	public void displayCustomers() {
		// TODO Auto-generated method stub
		
	}
	public void display(MyUberModel myUberModel) {
		// TODO Auto-generated method stub
		
	}
	public void displayDrivers() {
		// TODO Auto-generated method stub
		
	}
	
}
