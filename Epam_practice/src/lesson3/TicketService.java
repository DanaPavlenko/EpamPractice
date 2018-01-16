package lesson3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lesson3.entities.Station;
import lesson3.entities.Stay;
import lesson3.entities.Ticket;
import lesson3.entities.Train;

public class TicketService {

	private Train[] trains;

	public TicketService(Train[] trains) {
		this.trains = trains;
		setPlaces();
	}

	// set general number of places in each element of array of distances
	// between two closest stations
	public void setPlaces() {
		Map<Train, int[]> freePlaces = new HashMap<>();
		for (int i = 0; i < trains.length; i++) {
			int distances[] = new int[trains[i].getSchedule().getStays().size() - 1];
			for (int j = 0; j < distances.length; j++) {
				distances[j] = trains[i].getPlaces();
			}
			freePlaces.put(trains[i], distances);
		}
		Ticket.setFreePlaces(freePlaces);
	}

	// check free places in train from departure to arrival station
	public boolean checkFreePlaces(Train train, Station departure, Station arrival) {
		Ticket ticket = new Ticket(train, departure, arrival);
		if (ticket.ifFreePlaces())
			return true;
		return false;
	}

	// buy ticket on train from departure to arrival station
	public void buyTicket(Train train, Station departure, Station arrival) {
		Ticket ticket = new Ticket(train, departure, arrival);
		if (ticket.ifFreePlaces())
			ticket.setPlaceOccupied();
	}

	// search list of trains by departure and arrival stations
	public List<Train> searchByLocation(Station from, Station to) {
		List<Train> trainsArray = new ArrayList<>();

		for (int i = 0; i < trains.length; i++) {
			boolean isFromFound = false;
			Iterator<Stay> iterator = trains[i].getSchedule().getStays().iterator();

			while (iterator.hasNext()) {
				Stay tmp = iterator.next();
				if (tmp.getStation().equals(from))
					isFromFound = true;
				else if (tmp.getStation().equals(to) && isFromFound) {
					trainsArray.add(trains[i]);
					break;
				}
			}

		}

		return trainsArray;
	}

	// search list of trains by departure time, date and station
	public List<Train> searchByTime(LocalTime time, LocalDate date, String station) {

		List<Train> trainsArray = new ArrayList<>();
		for (int i = 0; i < trains.length; i++) {
			Iterator<Stay> iterator = trains[i].getSchedule().getStays().iterator();
			while (iterator.hasNext()) {
				Stay tmp = iterator.next();
				if (tmp.getStation().equals(station.toUpperCase()) && iterator.hasNext()) {
					if (tmp.getDepartureTime().isAfter(time) && (trains[i].getSchedule().ifDayOfMonth(date))
							&& (trains[i].getSchedule().ifDayOfWeek(date)))
						trainsArray.add(trains[i]);
					break;
				}
			}
		}

		return trainsArray;

	}

	// search list of trains by departure station and number of closest hours
	public List<Train> searchClosestByFreePlacesAndLocation(String location, int hour) {
		List<Train> trainsArray = new ArrayList<>();
		LocalDateTime toDateTime = LocalDateTime.now().plusHours(hour);
		LocalDate toDate = toDateTime.toLocalDate();
		LocalTime toTime = toDateTime.toLocalTime();
		LocalDate fromDate = LocalDate.now();
		for (int i = 0; i < trains.length; i++) {
			Iterator<Stay> iterator = trains[i].getSchedule().getStays().iterator();
			while (iterator.hasNext()) {
				Stay tmp = iterator.next();
				if (tmp.getStation().toString().startsWith(location) && iterator.hasNext()) {
					while (fromDate.isBefore(toDate.plusDays(1))) {
						if (trains[i].getSchedule().ifDayOfMonth(fromDate)
								&& trains[i].getSchedule().ifDayOfWeek(fromDate)) {
							if (fromDate.equals(LocalDate.now()) && tmp.getDepartureTime().isAfter(LocalTime.now())) {
								trainsArray.add(trains[i]);
								break;
							}
							if (fromDate.equals(toDate) && tmp.getDepartureTime().isBefore(toTime)) {
								trainsArray.add(trains[i]);
								break;
							}
							if (fromDate.isAfter(LocalDate.now()) && fromDate.isBefore(toDate)) {
								trainsArray.add(trains[i]);
								break;
							}
						}
						fromDate = fromDate.plusDays(1);
					}

				}

			}

		}
		return trainsArray;
	}

	// output list of trains
	void printList(List<Train> trains) {
		if (trains.isEmpty())
			System.out.println("На жаль, за Вашим запитом нічого не знайдено.");
		else {
			System.out.println("Результат пошуку:");
			for (Train train : trains)
				System.out.println(train.getId() + " " + train.getName());
		}
		System.out.println();
	}

}
