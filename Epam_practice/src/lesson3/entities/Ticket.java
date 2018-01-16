package lesson3.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

	private Train train;

	private Station departStation;

	private Station arriveStation;

	// create for each train array of distances between two closest stations
	private static Map<Train, int[]> freePlaces = new HashMap<>();

	public Ticket(Train train, Station departStation, Station arriveStation) {

		this.train = train;
		this.departStation = departStation;
		this.arriveStation = arriveStation;
	}

	// find indexes of stays in train to search free places
	private int[] findIndexes() {

		int[] indexes = new int[2];
		List<Stay> stays = train.getSchedule().getStays();
		for (int i = 0; i < stays.size(); i++) {
			if (stays.get(i).getStation().equals(departStation))
				indexes[0] = i;
			else if (stays.get(i).getStation().equals(arriveStation))
				indexes[1] = i;
		}
		return indexes;
	}

	// check free places in train between two stations
	public boolean ifFreePlaces() {
		int[] indexes = findIndexes();
		int[] places = freePlaces.get(train);
		for (int i = indexes[0]; i < indexes[1]; i++) {
			if (places[i] < 1)
				return false;
		}
		return true;

	}

	// set one place between two stations occupied
	public void setPlaceOccupied() {
		int[] indexes = findIndexes();
		int[] places = freePlaces.get(train);
		for (int i = indexes[0]; i < indexes[1]; i++) {
			places[i]--;
		}
	}

	public Train getTrain() {
		return train;
	}

	public Station getDepartStation() {
		return departStation;
	}

	public Station getArriveStation() {
		return arriveStation;
	}

	public static void setFreePlaces(Map<Train, int[]> freePlaces) {
		Ticket.freePlaces = freePlaces;
	}

}
