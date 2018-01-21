package CoffeePoint;

import CoffeePoint.Entities.Bill;
import CoffeePoint.Entities.BonusCard;
import CoffeePoint.Entities.CoffeePoint;
import CoffeePoint.Entities.Customer;
import CoffeePoint.Entities.Order;
import CoffeePoint.Entities.OrderItem;
import CoffeePoint.Entities.MenuEntities.Coffee;
import CoffeePoint.Entities.MenuEntities.HotDog;
import CoffeePoint.Entities.MenuEntities.Sandwich;
import CoffeePoint.Entities.MenuEntities.CoffeeDecorator.Chocolate;
import CoffeePoint.Entities.MenuEntities.CoffeeDecorator.Cream;
import CoffeePoint.Generator.MenuGenerator;
import CoffeePoint.PaymentService.CashPayment;
import CoffeePoint.PaymentService.CreditCardPayment;

public class Main {

	public static void main(String[] args) {

		CoffeePoint coffeePoint = new CoffeePoint();

		MenuGenerator generator = new MenuGenerator();

		coffeePoint.setMenu(generator.generateMenu());

		Customer customer = new Customer();
		System.out.println("Menu:");
		customer.watchMenu(coffeePoint);

		Order order = new Order();
		order.addItem(new OrderItem(new Coffee(), 1));
		order.addItem(new OrderItem(new Chocolate(new Coffee()), 2));
		order.addItem(new OrderItem(new Sandwich(), 3));

		System.out.println("First order:");
		customer.makeOrder(order);
		Bill bill = coffeePoint.generateBill(order);
		System.out.println("Cash payment:");
		customer.pay(new CashPayment(), bill);
		customer.addBonusCard(new BonusCard(27));

		Order order2 = new Order();
		order2.addItem(new OrderItem(new Cream(new Chocolate(new Coffee())), 2));
		order2.addItem(new OrderItem(new HotDog(), 1));

		System.out.println("Second order:");
		customer.makeOrder(order2);
		Bill bill1 = coffeePoint.generateBill(order2);
		System.out.println("Credit card payment:");
		customer.pay(new CreditCardPayment("1234 1234 1234 1234", "452", "02/18"), bill1);
		System.out.println("Bonus count:");
		customer.watchBonusCount();

	}

}
