package CarTask.motor;

public class ElectricMotor extends Motor {

	private int batteryCapacity;

	public ElectricMotor(int power, int batteryCapacity) {
		super(power);
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public void work() {
		System.out.println("Electric motor is working: PSHH-SHHH-SHHH");

	}

}
