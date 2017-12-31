package lesson3;

import java.time.LocalTime;

public class Stay {
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private String name;

	public Stay(String name, LocalTime arrivalTime, LocalTime departureTime) {
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public String getName() {
		return name;
	}

}
