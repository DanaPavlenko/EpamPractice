package CarTask.vehicle;

import CarTask.motor.Motor;
import CarTask.transmission.Transmission;

public abstract class Vehicle {

	private String model;

	private Motor motor;

	private Transmission transmission;

	public Vehicle() {
	}

	public Vehicle(String model, Motor motor, Transmission transmission) {
		this.model = model;
		this.motor = motor;
		this.transmission = transmission;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public void changeTransmission() {
		transmission.changeTransmission();
	}

	public void startDriving() {
		motor.work();
	}
	
	public abstract void drive();

}
