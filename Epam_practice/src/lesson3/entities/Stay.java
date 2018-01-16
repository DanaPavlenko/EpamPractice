package lesson3.entities;

import java.time.LocalTime;

public class Stay {
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Station station;

	public Stay(Station station, LocalTime arrivalTime, LocalTime departureTime) {
		this.station = station;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public Station getStation() {
		return station;
	}
	
	

}
