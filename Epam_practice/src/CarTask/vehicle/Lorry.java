package CarTask.vehicle;

import CarTask.motor.Motor;
import CarTask.transmission.Transmission;

public class Lorry extends Vehicle {

	private int bodyVolume;

	public Lorry(String model, Motor motor, Transmission transmission, int bodyVolume) {
		super(model, motor, transmission);
		this.bodyVolume = bodyVolume;
	}

	@Override
	public void drive() {
		startDriving();
		System.out.println("Lorry is driving");
	}

}
