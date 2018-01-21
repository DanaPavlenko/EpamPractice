package CoffeePoint.Entities;

public class BonusCard {

	private int id;

	private double bonusCount;

	public BonusCard(int id) {
		this.id = id;
	}

	public void setBonusCount(double bonusCount) {
		this.bonusCount = bonusCount;
	}

	public double getBonusCount() {
		return bonusCount;
	}

	public void addBonus(double amount) {
		bonusCount += amount;
	}

}
