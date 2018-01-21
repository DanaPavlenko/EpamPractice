package CoffeePoint.Entities;

import CoffeePoint.PaymentService.PaymentStrategy;

public class Customer {
	
	private BonusCard card;
	
	private Order order;

	public Customer() {
       
	}

	

	public Order getOrder() {
		return order;
	}
	
	public void addBonusCard(BonusCard card){
		this.card = card;
	}

	public void makeOrder(Order order) {
		this.order = order;
	for	(OrderItem item : order.getItems())
		System.out.println(item.getItem().getName()+" "+item.getNumber());
	   System.out.println("General price of your order is: "+order.getGeneralPrice());
	}
	
	
	
	public void pay(PaymentStrategy strategy, Bill bill){
		strategy.pay(bill, card);
		
	}
	
	public void watchMenu(CoffeePoint coffeePoint){
		coffeePoint.showMenu();
	}
	
	public void watchBonusCount(){
	if (card!=null)
		System.out.println("You have " + card.getBonusCount() + " bonuses");
	}
}
