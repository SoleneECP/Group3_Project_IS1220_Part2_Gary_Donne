package myUberMVC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import myUberUsers.AverageMarkSorting;
import myUberUsers.Car;
import myUberUsers.CarTypeDoesntExistException;
import myUberUsers.ChargesSorting;
import myUberUsers.Customer;
import myUberUsers.Driver;
import myUberUsers.FrequencySorting;
import myUberUsers.OccupationRateStrategy;

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
			
			catch(RideTypeDoesntExistException e) {
				System.out.println("this ridetype"+e.rideTypeEntered+"does not exist");
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
				System.out.println("The Car Type"+ e.getCarType() + "doesnt exist");
			}
		}
		sc.close();
	}
	
	
	/**
	 * Display the drivers and their parameters sorted according to their occupation rate or their verage mark
	 * @param sortingStrategy the sorting strategy
	 */
	public void displayDrivers(String sortingStrategy) {
		if(sortingStrategy.equalsIgnoreCase("mostappreciated")) {
			AverageMarkSorting sorting = new AverageMarkSorting();
			for (Driver d : sorting.sortDriver()) {
				System.out.println(d.toString());
			}
		}
		else if (sortingStrategy.equalsIgnoreCase("mostoccupied")) {
			OccupationRateStrategy sorting = new OccupationRateStrategy();
			for(Driver d : sorting.sortDriver()) {
				System.out.println(d.toString());
			}
		}
	}
	/**
	 * Display the customers and their parameters sorted according to their amount of 
	 * time or money spent in an Uber ride  
	 * @param sortingStrategy the sorting strategy
	 */
	public void displayCustomers(String sortingStrategy) {
		if(sortingStrategy.equalsIgnoreCase("mostfrequent")) {
			FrequencySorting sorting = new FrequencySorting();
			for (Customer c : sorting.sortCustomers()) {
				System.out.println(c.toString());
			}
		}
		else if(sortingStrategy.equalsIgnoreCase("mostcharged")) {
			ChargesSorting sorting = new ChargesSorting();
			for(Customer c : sorting.sortCustomers()) {
				System.out.println(c.toString());
			}
		}
	}
	
	/**
	 * Display the total amount of money cashed by all drivers in the myUber system.
	 * @param myUberModel
	 */
	public void displayTotalCashed(MyUberModel myUberModel) {
		double totalCash = 0;
		for (Customer c : myUberModel.customers) {
			totalCash+=c.getAmountOfCharges();
		}
		System.out.println(totalCash);
	}
	
	/**
	 * Display the cars and their parameters of MyUber System
	 */
	public void displayCars() {
		for(Car c : MyUberModel.cars) {
			System.out.println(c.toString());
		}
	}
	
	/**
	 * Display the customers and their parameters of MyUber System
	 */
	public void displayCustomers() {
		for(Customer c : MyUberModel.customers) {
			System.out.println(c.toString());
		}		
	}
	
	/**
	 * Display the cars, the drivers, the customers and their parameters of MyUber System
	 * @param myUberModel
	 */
	public void display(MyUberModel myUberModel) {
		displayDrivers();
		displayCustomers();
		displayCars();
	}
	
	/**
	 * Display the drivers and their parameters of MyUber System
	 */
	public void displayDrivers() {
		for (Driver d : MyUberModel.drivers) {
			System.out.println(d.toString());
		}		
	}
	
}
