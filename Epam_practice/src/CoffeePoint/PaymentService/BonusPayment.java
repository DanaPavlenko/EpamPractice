package CoffeePoint.PaymentService;

import CoffeePoint.Entities.Bill;
import CoffeePoint.Entities.BonusCard;

public class BonusPayment implements PaymentStrategy{

	@Override
	public void pay(Bill bill, BonusCard card) {
		
		if(card != null && card.getBonusCount()>=bill.calculatePayment())
			card.setBonusCount(card.getBonusCount()-bill.calculatePayment());
		else System.out.println("Choose another payment strategy");
		
	}

}
