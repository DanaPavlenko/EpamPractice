package lesson3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		TrainGenerator generator = new TrainGenerator();
		Train[] trains = generator.createTrains("TRRRains.txt");
		TrainSearcher service = new TrainSearcher(trains);

		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		boolean isInputed = false;

		while (isRun) {
			System.out.println("Натисніть 1 для пошуку по станціях");
			System.out.println("Натисніть 2 для пошуку по часу");
			System.out.println(
					"Натисніть 3 для пошуку по вільних місцях, перших буквах локації та найближчому часу відправлення");
			System.out.println("Натисніть будь-яку іншу клавішу для виходу");
			String choice = sc.next();
			switch (choice) {
			case "1": {
				System.out.println("Введіть станцію відправлення поїзда: ");
				String departure = sc.next();
				System.out.println("Введіть станцію прибуття поїзда: ");
				String arrival = sc.next();
				List<Train> trainsArray = service.searchByLocation(departure, arrival);
				service.printList(trainsArray);
			}

				break;

			case "2": {
				LocalTime time = null;
				LocalDate date = null;
				System.out.println("Введіть станцію відправлення поїзда: ");
				String departure = sc.next();
				System.out.println("Введіть дату відправлення поїзда (у форматі yyyy-mm-dd): ");
				while (!isInputed) {
					try {
						date = LocalDate.parse(sc.next());
						isInputed = true;
					} catch (Exception e) {
						System.out.println("Некоректний ввід! Спробуйте ще раз.");
					}
				}
				isInputed = false;
				System.out.println("Введіть час, після якого повинен відправлятися поїзд (у форматі hh:mm): ");
				while (!isInputed) {
					try {
						time = LocalTime.parse(sc.next());
						isInputed = true;
					} catch (Exception e) {
						System.out.println("Некоректний ввід! Спробуйте ще раз.");
					}
				}
				List<Train> trainsArray = service.searchByTime(time, date, departure);
				service.printList(trainsArray);

			}

				break;

			case "3": {
				int hours = 0;
				System.out.println("Введіть одну або кілька перших букв назви станції: ");
				String station = sc.next();
				isInputed = false;
				
				System.out.println("На скільки найближчих годин Ви розраховуєте?");
				while (!isInputed) {
					try {
						hours = Integer.parseInt(sc.next());
						isInputed = true;
					} catch (Exception e) {
						System.out.println("Некоректний ввід! Спробуйте ще раз.");
					}
				}
				List<Train> trainsArray = service.searchClosestByFreePlacesAndLocation(station, hours);
				service.printList(trainsArray);

			}

				break;

			default: {
				isRun = false;
				break;
			}
			}
		}
		sc.close();
	}
}
