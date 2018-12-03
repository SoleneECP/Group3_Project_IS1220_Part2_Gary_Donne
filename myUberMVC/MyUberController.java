package myUberMVC;

public class MyUberController {
	public MyUberView MyUberView; 
	public MyUber myUber;
	public void enterCommand(String command) throws IndexOutOfBoundsException,InvalidCommandException,NumberFormatException{
		String[] splitcommand = command.split("\\s+");
		switch(splitcommand[0]) {
		case "init":
			
			break;
		case "setup":
			
			break;
		case "addCarDriver":	
			myUber.addCarDriver(splitcommand[1],splitcommand[2],splitcommand[3]);
			break;
		case "addDriver":
			myUber.addDriver(splitcommand[1],splitcommand[2],splitcommand[3]);
			break;
		case "addCustomer":
			myUber.addCustomer(splitcommand[1],splitcommand[2]);
			break;
		case "setDriverStatus":
			
			break;
		case "displayState":
			myUberView.display();
			break;
		case "moveCustomer":
			myUber.moveCustomer(splitcommand[1],splitcommand[2],splitcommand[3]);
			break;
		case"moveCar":
			int xpos=Integer.parseInt(splitcommand[2]);
			int ypos=Integer.parseInt(splitcommand[3]);
			myUber.moveCar(splitcommand[1],xpos,ypos);
			break;
		
		case "ask4price":
			int custId=Integer.parseInt(splitcommand[1]);
			int xpos=Integer.parseInt(splitcommand[2]);
			int ypos=Integer.parseInt(splitcommand[3]);
			int time=Integer.parseInt(splitcommand[4]);
			myUber.ask4price(custId,xpos,ypos,time);
			break;
			
		case "displayCustomers":
			myUberView.displayCustomers();
			break;
		case "displayDrivers":
			
			
			break;
		case "simRide":
			
			break;
		case "simeRide_i":
			
			break;
		case "totalCashed":
			
			
			break;
		case "runTest":
			
			
			break;
		default:
			throw new InvalidCommandException(splitcommand[0]);
		
		}
	}
}
