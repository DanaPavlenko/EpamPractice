package WorkflowTask.status;

public class OpenedStatus extends Status {

	public String getName() {
		return "Opened";
	}

	@Override
	public boolean canBecomeResolved() {
		return true;

	}

}
