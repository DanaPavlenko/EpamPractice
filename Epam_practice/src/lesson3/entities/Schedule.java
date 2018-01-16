package lesson3.entities;

import java.time.LocalDate;
import java.util.List;

public class Schedule {

	private List<Stay> stays;

	private String daysOfMove;

	public Schedule(List<Stay> stays, String daysOfMove) {
		this.stays = stays;
		this.daysOfMove = daysOfMove;
	}

	public List<Stay> getStays() {
		return stays;
	}

	public String getDaysOfMove() {
		return daysOfMove;
	}

	// check if train departs this day of month(every day, odd, even)
	public boolean ifDayOfMonth(LocalDate date) {
		if (daysOfMove.charAt(0) == '0')
			return true;
		else if (daysOfMove.charAt(0) == '1' && date.getDayOfMonth() % 2 == 1)
			return true;
		else if (daysOfMove.charAt(0) == '2' && date.getDayOfMonth() % 2 == 0)
			return true;
		return false;
	}

	// check if train departs this day of week
	public boolean ifDayOfWeek(LocalDate date) {
		if (daysOfMove.charAt(date.getDayOfWeek().getValue()) == '1')
			return true;
		else
			return false;
	}

}
