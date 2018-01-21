package CoffeePoint.Entities.MenuEntities.CoffeeDecorator;

import CoffeePoint.Entities.MenuItem;
import CoffeePoint.Entities.MenuEntities.Coffee;

public abstract class CoffeeDecorator extends Coffee{
		
	protected final MenuItem item;

	public CoffeeDecorator(MenuItem item) {
    this.item = item;
    }
	
	  @Override
	    public int getPrice() {
	        return item.getPrice();
	    }

	  @Override
	    public String getName() {
	        return item.getName();
	    }
	
		

	
}
