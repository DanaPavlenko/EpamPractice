package CoffeePoint.Entities.MenuEntities.CoffeeDecorator;

import CoffeePoint.Entities.MenuItem;

public class MilkAdd extends CoffeeDecorator {
	
	private static int price = 5;
	
	private static String name = " with milk";
	
	
	public MilkAdd(MenuItem item) {
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
