package CoffeePoint.Entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

	List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public int getGeneralPrice() {
		int result = 0;
		for (OrderItem item : items) {
			result += item.getItem().getPrice() * item.getNumber();
		}
		return result;
	}

}
