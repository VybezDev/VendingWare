import java.util.*;
import java.io.*;

public interface Menu {
	
	public static  Code A0 = new Code("A0");
	public static  Code A1 = new Code("A1");
	public static  Code A2 = new Code("A2");
	public static  Code A3 = new Code("A3");
	public static  Code A4 = new Code("A4");
	public static  Code B0 = new Code("B0");
	public static  Code B1 = new Code("B1");
	public static  Code B2 = new Code("B2");
	public static  Code B3 = new Code("B3");
	public static  Code B4 = new Code("B4");
	public static  Code C0 = new Code("C0");
	public static  Code C1 = new Code("C1");
	public static  Code C2 = new Code("C2");
	public static  Code C3 = new Code("C3");
	public static  Code C4 = new Code("C4");
	
	public static ArrayList<Code> options = new ArrayList<Code>();
	
	public void display();
	
	public void populateOptions();
	
}
