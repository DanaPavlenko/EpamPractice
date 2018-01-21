package CoffeePoint.Entities;

public class Bill {

	private Order order;

	public Bill(Order order) {
		this.order = order;
	}

	public int calculatePayment() {
		return order.getGeneralPrice();
	}

}
