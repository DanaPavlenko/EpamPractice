package CarTask.motor;

public class PetrolMotor extends Motor {

	private int tankCapacity;

	public PetrolMotor(int power, int tankCapacity) {
		super(power);
		this.tankCapacity = tankCapacity;
	}

	@Override
	public void work() {
		System.out.println("Petrol motor is working: BRRR-BRRR-BRRR");
	}

}
