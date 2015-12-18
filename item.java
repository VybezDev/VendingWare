import java.util.*;
public class Item {
	
	private static int DEFAULT = 10;
	
	private String name;
	private double cost;
	//private Type type;
	private int amount;
		
	public Item(){
		amount = DEFAULT;
	}
	
	public Item(Item item){
		this.name = item.getName();
		this.cost = item.getCost();
		this.amount = item.getAmount();
				
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(cost) != Double
				.doubleToLongBits(other.cost))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "[Item=" + name + ",\t cost=" + " $"+cost + ",\t amount=" + amount
				+ "]";
	}

	public static void main(String [] args){
		
		Item test = new Item();
	}
	
}
