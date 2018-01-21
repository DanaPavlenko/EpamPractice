package CoffeePoint.Entities.MenuEntities;

import CoffeePoint.Entities.MenuItem;

public class Coffee extends MenuItem{
	
	private static String name = "Coffee";
	
	private static int price = 15;

	public Coffee() {
		super(name, price);
	}

}
