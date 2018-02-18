package WorkflowTask.entities.status;

public class OpenedStatus extends Status {

	public String getName() {
		return "Opened";
	}

	@Override
	public boolean canBecomeAssigned() {
		return true;

	}

}
