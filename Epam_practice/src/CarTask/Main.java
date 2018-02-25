package CarTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import CarTask.motor.ElectricMotor;
import CarTask.motor.Motor;
import CarTask.motor.PetrolMotor;
import CarTask.transmission.AutomaticTransmission;
import CarTask.transmission.ManualTransmission;
import CarTask.transmission.Transmission;
import CarTask.vehicle.Bus;
import CarTask.vehicle.Car;
import CarTask.vehicle.Lorry;
import CarTask.vehicle.Type;
import CarTask.vehicle.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		
		Vehicle car = new Car("BR127", new ManualTransmission(7), new ElectricMotor(27, 20), Type.MINIVAN);
		car.drive();
		car.changeTransmission();
		Vehicle bus = new Bus("1488", new PetrolMotor(12, 10), new AutomaticTransmission(5), 43);
		bus.drive();
		bus.changeTransmission();
		Vehicle lorry = new Lorry ("VAZ1", new PetrolMotor(23, 15), new ManualTransmission(4),150);
		lorry.drive();
		lorry.changeTransmission();
		
	}
	
	
	

}

