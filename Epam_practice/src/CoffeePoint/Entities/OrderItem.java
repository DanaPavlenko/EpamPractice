package CoffeePoint.Entities;

public class OrderItem {

	private MenuItem item;

	private int number;

	public OrderItem(MenuItem item, int number) {

		this.item = item;
		this.number = number;

	}

	public MenuItem getItem() {
		return item;
	}

	public void setItem(MenuItem item) {
		this.item = item;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
