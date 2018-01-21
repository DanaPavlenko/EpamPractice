package CoffeePoint.PaymentService;

import CoffeePoint.Entities.Bill;
import CoffeePoint.Entities.BonusCard;

public class CreditCardPayment implements PaymentStrategy{
	
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	

	public CreditCardPayment(String cardNumber, String cvv, String dateOfExpiry) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}



	@Override
	public void pay(Bill bill, BonusCard card) {
		System.out.println(bill.calculatePayment() +" has been debited from your card");
		if(card != null) card.setBonusCount(card.getBonusCount()+0.05*bill.calculatePayment());
	}

}
