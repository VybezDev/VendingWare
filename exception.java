import edu.cuny.csi.csc330.spring15.newradio.RadioException;

public class VendingMachineException extends Exception {

	public static int	NotEnoughMoney = 0;
	public static int	OutOfStock = 1;
	public static int 	ItemGotStuck = 2;
	public static int 	InvalidSelection = 3;
	public static int 	TooMuchMoney = 4;
	protected int code;
	
	public VendingMachineException(){
		
		
	}
	
	 public VendingMachineException(int code) { 
	    	//super(message);
	    	this.code = code;
	    } 
	
	public static String[]  MESSAGE = { 
  		"Not Enough Money", 
  		"Out Of Stock", 
  		"Item Got Stuck",
  		"Invalid Selection",
  		"Too Much Money"
  } ;

	public String toString() {
		return "VendingMachineException [code=" + code + ", toString()="
				+ super.toString() + "]\n" + MESSAGE[code] ;
	}

	public static void main(String [] args ) {
		// test w/o code 
    	VendingMachineException re = new VendingMachineException();
		System.out.println("Ex: " + re);
		
		// test with code 
		re = new VendingMachineException( VendingMachineException.OutOfStock);
		System.out.println("Ex: " + re);

    }

	
}
