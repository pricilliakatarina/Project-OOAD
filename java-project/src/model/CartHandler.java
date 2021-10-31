package model;

public class CartHandler {
	private int iD, quantity, price;
	private String name;
	
	public CartHandler(int iD, int quantity, int price, String name) {
		super();
		this.iD = iD;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
