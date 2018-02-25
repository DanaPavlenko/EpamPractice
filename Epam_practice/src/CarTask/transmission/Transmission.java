package CarTask.transmission;

public abstract class Transmission {

	private int transmissionCount;

	public Transmission(int transmission) {
		this.transmissionCount = transmission;
	}

	public int getTransmissionCount() {
		return transmissionCount;
	}

	public void setTransmissionCount(int transmissionCount) {
		this.transmissionCount = transmissionCount;
	}

	public abstract void changeTransmission();

}
