package lesson3;

import java.time.LocalDate;
import java.util.List;

public class Train {
	private int id;
	private String name;
	private List<Stay> stations;
	private int freePlaces;
	private String schedule;

	public Train() {
	}

	public Train(int id, String name, List<Stay> stays, String schedule, int freePlaces) {
		this.id = id;
		this.name = name;
		this.stations = stays;
		this.schedule = schedule;
		this.freePlaces = freePlaces;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Stay> getStations() {
		return stations;
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	// check if train departs this day of month(every day, odd, even)
	public boolean ifDayOfMonth(LocalDate date) {
		if (schedule.charAt(0) == '0')
			return true;
		else if (schedule.charAt(0) == '1' && date.getDayOfMonth() % 2 == 1)
			return true;
		else if (schedule.charAt(0) == '2' && date.getDayOfMonth() % 2 == 0)
			return true;
		return false;
	}

	// check if train departs this day of week
	public boolean ifDayOfWeek(LocalDate date) {
		if (schedule.charAt(date.getDayOfWeek().getValue()) == '1')
			return true;
		else
			return false;
	}

}
