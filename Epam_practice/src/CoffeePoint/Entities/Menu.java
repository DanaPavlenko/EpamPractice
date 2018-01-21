package CoffeePoint.Entities;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	List<MenuItem> MenuItems = new ArrayList<>();
	
	public Menu() {
	}

	public void getMenu() {
		for (MenuItem item : MenuItems)
			System.out.println(item.getName()+" "+item.getPrice());
	}

	public Menu(List<MenuItem> MenuItems) {
		this.MenuItems = MenuItems;
	}
	
	public void addItem(MenuItem item){
		MenuItems.add(item);
	}
	
	
}
