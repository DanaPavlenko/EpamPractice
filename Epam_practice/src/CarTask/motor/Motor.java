package CarTask.motor;

public abstract class Motor {

	private int power;

	public Motor(int power) {
		this.power = power;
	}

	public abstract void work();

}
