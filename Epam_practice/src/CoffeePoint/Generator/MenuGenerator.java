package CoffeePoint.Generator;

import CoffeePoint.Entities.Menu;
import CoffeePoint.Entities.MenuItem;
import CoffeePoint.Entities.MenuEntities.Coffee;
import CoffeePoint.Entities.MenuEntities.HotDog;
import CoffeePoint.Entities.MenuEntities.Sandwich;

public class MenuGenerator {

	private Menu menu = new Menu();

	public Menu generateMenu() {
		MenuItem sandwich = new Sandwich();
		MenuItem hotdog = new HotDog();
		MenuItem coffee = new Coffee();

		menu.addItem(sandwich);
		menu.addItem(hotdog);
		menu.addItem(coffee);

		return menu;
	}

}
