package CarTask.vehicle;

import CarTask.motor.Motor;
import CarTask.transmission.Transmission;

public class Car extends Vehicle {

	private Type type;

	public Car(String model, Transmission transmission, Motor motor, Type type) {
		super(model, motor, transmission);
		this.type = type;
	}

	@Override
	public void drive() {
		startDriving();
		System.out.println("Car is driving");

	}

}
