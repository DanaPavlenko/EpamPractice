package WorkflowTask.status;

public class ReopenedStatus extends Status {

	public String getName() {
		return "Reopened";
	}

	@Override
	public boolean canBecomeResolved() {
		return true;
	}
}
