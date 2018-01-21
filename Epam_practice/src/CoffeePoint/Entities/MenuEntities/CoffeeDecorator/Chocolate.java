package CoffeePoint.Entities.MenuEntities.CoffeeDecorator;

import CoffeePoint.Entities.MenuItem;

public class Chocolate extends CoffeeDecorator {
	
	private static int price = 4;
	
	private static String name = " with chocolate";
	
	
	public Chocolate(MenuItem item) {
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
