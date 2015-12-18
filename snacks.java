import java.util.*;
import java.io.*;

public class Snacks implements Menu {

	private double DEFAULT_PRICE = 1.50;
	protected static Map<Code, Item> hashMap = new HashMap<Code, Item>();
	
	public Snacks(){
		this.populateOptions();
		try {
			this.readIn();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Item getItem(String temp) throws VendingMachineException{
		boolean excep = false;
		
		for (Code codes : options){
			if (codes.code.equals(temp)){
				excep = true;
			}
		}
		
		if (!excep){
			throw new VendingMachineException(3);
		}
		Code tempCode = new Code(temp);
		Item toReturn = new Item (hashMap.get(tempCode));
		return toReturn;
	}
	
	public void readIn() throws FileNotFoundException, IOException{
		
		String fileName = "/Users/Omar/Desktop/CSC_330_WorkSpace/CSC_330/src/edu/cuny/csi/csc330/spring15/VendingMachine/Snacks.txt";
			
		java.io.FileReader fileReader = new java.io.FileReader(fileName);  
    	BufferedReader bufferedReader = new BufferedReader(fileReader);
    	//StringBuffer stringBuffer = new StringBuffer();
    	String line; 
    	int counter = 0;
    	while( ( line = bufferedReader.readLine() ) != null ) {
    		//stringBuffer.append(line);
    		Item temp = new Item();
    		temp.setName(line);
    		temp.setCost(DEFAULT_PRICE);
    		
    		hashMap.put((options.get(counter)), temp);
    		counter++;
   
        }
	      
    	fileReader.close();
	}
	
	public void populateOptions(){
		if (!options.contains(A0)){
		options.add(A0);
		options.add(A1);
		options.add(A2);
		options.add(A3);
		options.add(A4);
		options.add(B0);
		options.add(B1);
		options.add(B2);
		options.add(B3);
		options.add(B4);
		}
		
		
	}
	
	public void display(){
		
		for(Code codes : options){
		System.out.println(codes + " " + hashMap.get(codes));
		}
	}
	
	public static void main(String [] args){
		
		Snacks sn = new Snacks();		
		Code tempp = new Code( "A3");
		
		sn.display();
		
		try {
			sn.getItem("A3");
		} catch (VendingMachineException e) {
			// TODO Auto-generated catch block
			e.code = 3;
			System.err.println(e);
		}
		
		//System.out.println(sn.getItem(tempp));
	}
}
