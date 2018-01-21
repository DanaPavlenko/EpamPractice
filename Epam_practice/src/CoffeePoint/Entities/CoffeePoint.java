package CoffeePoint.Entities;

public class CoffeePoint {
	
	private Menu menu;
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void showMenu(){
		menu.getMenu();
	}
	
	public Bill generateBill(Order order){
		return new Bill(order);
	}

}
