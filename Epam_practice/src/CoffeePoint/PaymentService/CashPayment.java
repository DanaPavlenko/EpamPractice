package CoffeePoint.PaymentService;

import java.util.Scanner;

import CoffeePoint.Entities.Bill;
import CoffeePoint.Entities.BonusCard;

public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(Bill bill, BonusCard card) {	
		System.out.println("You have paid using cash.");
		if(card != null) card.setBonusCount(card.getBonusCount()+0.05*bill.calculatePayment());
	}

}
