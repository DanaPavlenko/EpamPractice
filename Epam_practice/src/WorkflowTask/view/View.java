package WorkflowTask.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import WorkflowTask.entities.Task;

public class View {

	private Task currentTask;
	private List<Task> tasks;
	private Map<String, String> menu;
	private Map<String, Printable> menuItems;
	private static Scanner input = new Scanner(System.in);

	public View() {
		this.tasks = new ArrayList<>();
		this.menu = new LinkedHashMap<>();
		this.menuItems = new LinkedHashMap<>();

		this.menu.put("1", "1 - add task and make it current");
		this.menu.put("2", "2 - show current task");
		this.menu.put("3", "3 - show all tasks");
		this.menu.put("4", "4 - choose task from list for work");

		this.menu.put("5", "5 - set opened status for current task");
		this.menu.put("6", "6 - set assigned status for current task");
		this.menu.put("7", "7 - set resolved status for current task");
		this.menu.put("8", "8 - set closed status for current task");
		this.menu.put("9", "9 - set reopened status for current task");

		this.menu.put("Q", "Q - for exit");

		this.menuItems.put("1", this::addTask);
		this.menuItems.put("2", this::showCurrentTask);
		this.menuItems.put("3", this::showAllTasks);
		this.menuItems.put("4", this::chooseTaskForWork);

		this.menuItems.put("5", this::setOpenedStatus);
		this.menuItems.put("6", this::setAssignedStatus);
		this.menuItems.put("7", this::setResolvedStatus);
		this.menuItems.put("8", this::setClosedStatus);
		this.menuItems.put("9", this::setReopenedStatus);

	}

	private void addTask() {
		System.out.println("Enter task name:");
		String name = input.nextLine();
		currentTask = new Task(name);
		tasks.add(currentTask);
		System.out.println("Task " + name + " is created");
	}

	private void showCurrentTask() {

		System.out.println(currentTask.toString());
	}

	private void showAllTasks() {
		if (!tasks.isEmpty()) {
			for (Task task : tasks)
				System.out.println(task.toString());
		} else
			System.out.println("Task list is empty");
	}

	private boolean isTaskInList() {
		System.out.println("Enter task name:");
		String name = input.next();
		for (Task task : tasks) {
			if (task.getName().equals(name)) {
				this.currentTask = task;
				return true;
			}
		}
		return false;
	}

	private void chooseTaskForWork() {
		if (tasks.isEmpty())
			System.out.println("Nothing to choose! Add tasks");
		else if (isTaskInList())
			System.out.println("Your current task has changed");
		else
			System.out.println("Such task doesn't exist. Add it or choose another one");
	}

	private void setOpenedStatus() {
		currentTask.setOpenedStatus();
	}

	private void setAssignedStatus() {
		currentTask.setAssignedStatus();
	}

	private void setReopenedStatus() {
		currentTask.setReopenedStatus();
	}

	private void setClosedStatus() {
		currentTask.setClosedStatus();
	}

	private void setResolvedStatus() {
		currentTask.setResolvedStatus();
	}

	private void outputMenu() {
		System.out.println("\nMENU:");
		for (String key : menu.keySet())
			if (key.length() == 1)
				System.out.println(menu.get(key));
	}

	public void show() {
		String keyMenu;
		do {
			outputMenu();
			System.out.println("Please, select menu point.");
			keyMenu = input.nextLine().toUpperCase();
			try {
				menuItems.get(keyMenu).print();
			} catch (NullPointerException e) {
				System.out.println("Firstly add task!");
			} catch (Exception e) {
				System.out.println("Something got wrong! Please, try again");
			}
		} while (!keyMenu.equals("Q"));
	}
}
