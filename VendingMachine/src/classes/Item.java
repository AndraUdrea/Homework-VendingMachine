package classes;

public class Item {

	private String name;
	private int id;
	private double price;
	private int numOfItems;

	public Item(int id, String name, double price, int numOfItems) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.numOfItems = numOfItems;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return this.price;
	}

	public void add(int number) {
		this.numOfItems += number;
	}

	public void remove(int number) {
		this.numOfItems -= number;
	}

	public int getNumOfItems() {
		return this.numOfItems;
	}

	@Override
	public String toString() {
		return id + "-->" + name + "    price:" + price + "; num of available items: " + numOfItems;
	}

}
