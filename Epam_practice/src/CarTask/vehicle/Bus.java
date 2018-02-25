package CarTask.vehicle;

import CarTask.motor.Motor;
import CarTask.transmission.Transmission;

public class Bus extends Vehicle {

	private int numberOfPlaces;

	public Bus(String model, Motor motor, Transmission transmission, int numberOfPlaces) {
		super(model, motor, transmission);
		this.numberOfPlaces = numberOfPlaces;
	}

	@Override
	public void drive() {
		startDriving();
		System.out.println("Bus is driving");
	}

}
