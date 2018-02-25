package CarTask.transmission;

import java.util.Scanner;

public class ManualTransmission extends Transmission {

	public ManualTransmission(int transmission) {
		super(transmission);
	}

	@Override
	public void changeTransmission() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter transmission you would like to change to:");
		int transmission = sc.nextInt();
		System.out.println("Transmission changed to " + transmission);

	}

}
