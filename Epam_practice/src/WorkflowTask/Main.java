package WorkflowTask;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		task.setOpenedStatus();
		task.setResolvedStatus();
		task.setClosedStatus();
		task.showStatus();
	}

}
