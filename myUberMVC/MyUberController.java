package myUberMVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import myUberRidesOperations.RideType;
import myUberUsers.CarTypeDoesntExistException;

/**
 * 
 * The Model Controller for the MyUber system
 *
 */
public class MyUberController {
	/**
	 * The controller associated view
	 */
	public MyUberView myUberView; 
	/**
	 * The controller associated model
	 */
	public MyUberModel myUberModel;
	
	public synchronized void enterCommand(String command) throws IndexOutOfBoundsException,InvalidCommandException,NumberFormatException,FileNotFoundException,CarTypeDoesntExistException{
		String[] splitcommand = command.split("\\s+");
		int custID,xpos,ypos,time,driverMark;
		switch(splitcommand[0]) {
		case "init":
			File file = new File(splitcommand[1]); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st;			
			try {
				while ((st = br.readLine()) != null) {
					enterCommand(st);
				  }
			} catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			break;
			
		case "setup":
			int nStandard=Integer.parseInt(splitcommand[2]);
			int nBerlin=Integer.parseInt(splitcommand[3]);
			int nVan=Integer.parseInt(splitcommand[4]);
			int nCustomers=Integer.parseInt(splitcommand[5]);
			this.myUberModel=new MyUberModel(nStandard,nBerlin,nVan,nCustomers);
			break;
		case "addCarDriver":	
			myUberModel.addCarDriver(splitcommand[1],splitcommand[2],splitcommand[3]);
			myUberView.displayCars();
			myUberView.displayDrivers();
			break;
		case "addDriver":
			myUberModel.addDriver(splitcommand[1],splitcommand[2],splitcommand[3]);
			myUberView.displayDrivers();
			break;
		case "addCustomer":
			myUberModel.addCustomer(splitcommand[1],splitcommand[2]);
			myUberView.displayCustomers();
			break;
		case "setDriverStatus":
			myUberModel.setDriverStatus(splitcommand[1],splitcommand[2],splitcommand[3]);
			myUberView.displayDrivers();
			break;
		case "displayState":
			myUberView.display(myUberModel);
			break;
		case "moveCustomer":
			myUberModel.moveCustomer(splitcommand[1],splitcommand[2],splitcommand[3]);
			myUberView.displayCustomers();
			break;
		case"moveCar":
			xpos=Integer.parseInt(splitcommand[2]);
			ypos=Integer.parseInt(splitcommand[3]);
			myUberModel.moveCar(splitcommand[1],xpos,ypos);
			myUberView.displayCars();
			break;
		case "ask4price":
			custID=Integer.parseInt(splitcommand[1]);
			xpos=Integer.parseInt(splitcommand[2]);
			ypos=Integer.parseInt(splitcommand[3]);
			time=Integer.parseInt(splitcommand[4]);
			myUberModel.ask4price(custID,xpos,ypos,time);
			break;
			
		case "displayCustomers":
			myUberView.displayCustomers(splitcommand[1]);
			break;
		case "displayDrivers":
			myUberView.displayDrivers(splitcommand[1]);
			break;
		case "simRide":
			custID=Integer.parseInt(splitcommand[1]);
			xpos=Integer.parseInt(splitcommand[2]);
			ypos=Integer.parseInt(splitcommand[3]);
			time=Integer.parseInt(splitcommand[4]);
			RideType rideType=RideType.valueOf(splitcommand[5]);
			driverMark=Integer.parseInt(splitcommand[6]);
			myUberModel.simRide(custID, xpos,ypos,time,rideType,driverMark);
			break;
		case "simeRide_i":
			custID=Integer.parseInt(splitcommand[1]);
			xpos=Integer.parseInt(splitcommand[2]);
			ypos=Integer.parseInt(splitcommand[3]);
			time=Integer.parseInt(splitcommand[4]);
			myUberModel.simRide(custID, xpos, ypos, time);
			break;
		case "totalCashed":
			myUberView.displayTotalCashed(myUberModel);			
			break;
		case "runTest":
			File testfile = new File(splitcommand[1]); 
			BufferedReader testbr = new BufferedReader(new FileReader(testfile)); 
			String string;
			PrintStream fileStream = new PrintStream("testScenario"+splitcommand[1].charAt(13)+"output.txt");
			PrintStream oldStream=System.out;
			System.setOut(fileStream);
			try {
				while ((string = testbr.readLine()) != null) {
					enterCommand(string);
				  }
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					testbr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			System.setOut(oldStream);
			}
			
			break;
		default:
			throw new InvalidCommandException(splitcommand[0]);
		
		}
	}
}
