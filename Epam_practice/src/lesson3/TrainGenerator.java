package lesson3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lesson3.entities.Schedule;
import lesson3.entities.Station;
import lesson3.entities.Stay;
import lesson3.entities.Train;

public class TrainGenerator {
	// create array of trains
	public Train[] createTrains(String file) {
		List<String> lines = parceFile(file);
		Train[] trains = parceStringsInObjects(lines);
		return trains;
	}

	// parse text file in list of strings
	private List<String> parceFile(String file) {
		BufferedReader reader;
		String line;
		List<String> lines = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(file));
			try {
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return lines;
	}

	// parse list of strings in objects of class Train
	private Train[] parceStringsInObjects(List<String> lines) {
		List<Train> trains = new ArrayList<>();

		for (String line : lines) {
			String[] splitted = line.split(" ");
			String id = splitted[0];
			String name = splitted[1];
			List<Stay> stays = new ArrayList<>();
			stays.add(new Stay(Station.valueOf(splitted[2].toUpperCase()), null, LocalTime.parse(splitted[3])));
			for (int i = 4; i < splitted.length - 4; i += 3) {
				Station station = Station.valueOf(splitted[i].toUpperCase());
				LocalTime arrivalTime = LocalTime.parse(splitted[i + 1]);
				LocalTime departureTime = LocalTime.parse(splitted[i + 2]);
				stays.add(new Stay(station, arrivalTime, departureTime));
			}
			stays.add(new Stay(Station.valueOf(splitted[splitted.length - 4].toUpperCase()), LocalTime.parse(splitted[splitted.length - 3]), null));
			String daysOfMove = splitted[splitted.length - 2];
			int placesNumber = Integer.valueOf(splitted[splitted.length - 1]);
			trains.add(new Train(id, name, placesNumber, new Schedule(stays, daysOfMove)));
		}

		Train[] arrayOfTrains = trains.toArray(new Train[trains.size()]);
		for (int i = 0; i < arrayOfTrains.length; i++) {
			System.out.println(arrayOfTrains[i].getId());
		}
		return arrayOfTrains;
	}

}
