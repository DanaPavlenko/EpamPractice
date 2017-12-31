package lesson3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrainSearcher {

	private Train[] trains;

	public TrainSearcher(Train[] trains) {
		this.trains = trains;
	}

	public Train[] getTrains() {
		return trains;
	}

	// search list of trains by departure and arrival stations
	public List<Train> searchByLocation(String from, String to) {
		List<Train> trainsArray = new ArrayList<>();

		for (int i = 0; i < trains.length; i++) {
			boolean isFromFound = false;
			Iterator<Stay> iterator = trains[i].getStations().iterator();

			while (iterator.hasNext()) {
				Stay tmp = iterator.next();
				if (tmp.getName().equals(from))
					isFromFound = true;
				else if (tmp.getName().equals(to) && isFromFound) {
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
			Iterator<Stay> iterator = trains[i].getStations().iterator();
			while (iterator.hasNext()) {
				Stay tmp = iterator.next();
				if (tmp.getName().equals(station) && iterator.hasNext()) {
					if (tmp.getDepartureTime().isAfter(time) && (trains[i].ifDayOfMonth(date))
							&& (trains[i].ifDayOfWeek(date)))
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
			if (trains[i].getFreePlaces() != 0) {
				Iterator<Stay> iterator = trains[i].getStations().iterator();
				while (iterator.hasNext()) {
					Stay tmp = iterator.next();
					if (tmp.getName().startsWith(location) && iterator.hasNext()) {
						while (fromDate.isBefore(toDate.plusDays(1))) {
							if (trains[i].ifDayOfMonth(fromDate) && trains[i].ifDayOfWeek(fromDate)) {
								if (fromDate.equals(LocalDate.now())
										&& tmp.getDepartureTime().isAfter(LocalTime.now())) {
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
