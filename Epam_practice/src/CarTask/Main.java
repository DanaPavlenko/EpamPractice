package CarTask;

import CarTask.motor.*;
import CarTask.transmission.*;
import CarTask.vehicle.*;

public class Main {

	public static void main(String[] args) {

		Vehicle car = new Car("BR127", new ManualTransmission(7), new ElectricMotor(27, 20), Type.MINIVAN);
		car.drive();
		car.changeTransmission();
		Vehicle bus = new Bus("1488", new PetrolMotor(12, 10), new AutomaticTransmission(5), 43);
		bus.drive();
		bus.changeTransmission();
		Vehicle lorry = new Lorry("VAZ1", new PetrolMotor(23, 15), new ManualTransmission(4), 150);
		lorry.drive();
		lorry.changeTransmission();

	}

}
