package CoffeePoint.PaymentService;

import CoffeePoint.Entities.Bill;
import CoffeePoint.Entities.BonusCard;

public interface PaymentStrategy {

	public void pay(Bill bill, BonusCard card);
	
	
}
