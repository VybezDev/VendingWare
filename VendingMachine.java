import java.math.*;
import java.util.*;

import edu.cuny.csi.csc330.spring15.lab1.Randomizer;

public class VendingMachine {
	
	private static int DRINK = 20;
	private static int SNACK = 30;
	private int optToDisplay;
	private Drinks dr;
	private Snacks sn;
	private double change;
	private String input;
	private String typeOfProduct;
	private boolean keepgoing = true;
	
	// Constructor
	public VendingMachine(){
		
		while (true){
		
			displayOptions();
		    dispense(select());
		    System.out.println();
		}		
	}
	
	// This method asks the user which vending machine to look at, snack or drink.
	// It then returns an int that is tied with either vending machine
	private int snackOrDrink(){
		
		Scanner scanner = new Scanner(System.in);
		String in;
		keepgoing = true;
		while (keepgoing){
		System.out.println("Would You Like a Drink[D] or a Snack[S]?");
		in = scanner.nextLine();
		
		if (in.equals("D") || in.equals("d")) {
			typeOfProduct = "Drink";
			return DRINK;
		}
		else if (in.equals("S") || in.equals("s")){
			typeOfProduct = "Snack";
			return SNACK;
		}
		
		}
		return 0;
	}
	
	// This method displays the menu that the user chose
	// the int that is returned from snackOrDrink() is then used to determine which menu to display
	private void displayOptions(){
		
		optToDisplay = snackOrDrink();
		
		if (optToDisplay == SNACK){
			Snacks sn = new Snacks();
			sn.display();
			
		}
		else if (optToDisplay == DRINK){
			
			Drinks dr = new Drinks();
			dr.display();
		}
	}

	// This method asks the user to select an item from the menu. If the input entered does not match
	// any of the available options, an exception is thrown
	// If the selection is there, the method returns the item that was selected
	private Item select(){
		
		Scanner scan = new Scanner(System.in);
		boolean keepgoing2 = true;
		System.out.println("\nPlease select one of the options above: ");
		while (keepgoing2){

		input = scan.nextLine();
		
		
		try {
			if (optToDisplay == SNACK){
				
				Item selection = Snacks.getItem(input);
				keepgoing2 = false;
				return selection;
				//System.out.println(selection);
			}
			
			else if (optToDisplay == DRINK){
				Item selection = Drinks.getItem(input);
				keepgoing2 = false;
				return selection;
			
				}
			
		} catch (VendingMachineException e) {
			// TODO Auto-generated catch block
			e.code = 3;
			System.err.println(e);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("\nPlease try again: ");
			
		}
		
		}
		return null;
	}
	
	// This method takes in an item (the one returned from select() ) and asks the user to enter
	// some amount of money
	private void dispense (Item item) {
		
		System.out.println("You have selected: " + item);
		boolean keepgoing3 = true;
		while (keepgoing3){
		System.out.println("\nPlease insert money: ");
		Scanner scan = new Scanner(System.in);
		double moneyIn = scan.nextDouble();
		
		try {
			
			enoughMoney(item,moneyIn);
			keepgoing3 = false;
			
		} catch (VendingMachineException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			
			if (e.code == 4){
				System.out.println("\nMaximum amount accepted is $10. Please try again.\n");
			}
			
		}
		
		}
		try{
			process(item);
		}
		catch (VendingMachineException e) {
			// TODO Auto-generated catch block
			System.err.println(e);	
			delay();
			System.out.println("Sorry, you just got robbed, goodbye :)");
		}
	}
	
	// This method simulates the Vending Machine processing and every one in five times, the item will
	// get stuck.
	private void process(Item item) throws VendingMachineException{
		Randomizer ran = new Randomizer();
		int rand = ran.generateInt(1,6);
		
		System.out.print("Thank you, please wait while we process");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.print("..");
		delay();
		System.out.println("..");
		
		if (rand == 2){
			throw new VendingMachineException(2);
			
		}
		
		System.out.println("\nHere is your " + typeOfProduct +": " + item.getName());
		System.out.println("And here is your change: $" + change);
			
		// this line does not work??????
		item.setAmount(item.getAmount()-1);
		
	}
	
	//This will return the change or throw an exception if there is not enough or too
	// much money entered
	private void enoughMoney(Item item, double moneyIn) throws VendingMachineException{
		
		if (moneyIn < item.getCost() ){
			throw new VendingMachineException(0);
		}
		else if (moneyIn > 10){
			throw new VendingMachineException(4);
		}
		
		change = moneyIn - item.getCost();
	}
	
	//This is just used above to simulate the delay in the processing of the vending machine
	private void delay(){
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
