package java102.serializing;

import java.io.Serializable;

public class Item implements Serializable {
	
	int id;
	String name;
	transient double cost;
	public Item(){}
	public Item(int id, String name, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
	

}
