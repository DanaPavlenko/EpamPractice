package lesson3.entities;

public class Train {
	private String id;
	private String name;
	private int places;
	private Schedule schedule;

	public Train() {
	}

	public Train(String id, String name, int places, Schedule schedule) {
		this.id = id;
		this.name = name;
		this.places = places;
		this.schedule = schedule;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}
