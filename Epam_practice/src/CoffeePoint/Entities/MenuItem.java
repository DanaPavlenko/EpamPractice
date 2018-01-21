package CoffeePoint.Entities;

public abstract class MenuItem {
	
	private String name;
	
	private int price;
	
	public MenuItem(){
		
	}

	public MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
