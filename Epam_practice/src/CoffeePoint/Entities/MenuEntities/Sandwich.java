package CoffeePoint.Entities.MenuEntities;

import CoffeePoint.Entities.MenuItem;

public class Sandwich extends MenuItem{
private static String name = "Sandwich";
	
	private static int price = 20;

	public Sandwich() {
		super(name, price);
	}
}
