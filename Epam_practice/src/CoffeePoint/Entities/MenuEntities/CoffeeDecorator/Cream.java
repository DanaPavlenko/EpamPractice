package CoffeePoint.Entities.MenuEntities.CoffeeDecorator;

import CoffeePoint.Entities.MenuItem;

public class Cream extends CoffeeDecorator {
	
	private static int price = 3;
	
	private static String name = " with cream";
	
	
	public Cream(MenuItem item) {
		super(item);
	}

	@Override
	public int getPrice() {
		return item.getPrice() + price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return item.getName() + name;
	}

}
