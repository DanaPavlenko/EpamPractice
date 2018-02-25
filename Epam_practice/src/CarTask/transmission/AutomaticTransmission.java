package CarTask.transmission;

public class AutomaticTransmission extends Transmission {

	public AutomaticTransmission(int transmission) {
		super(transmission);
	}

	@Override
	public void changeTransmission() {
		System.out.println("Your engine changed speed of rotation! Transmission has changed");
	}

}
