package WorkflowTask.entities.status;

public class ReopenedStatus extends Status {

	public String getName() {
		return "Reopened";
	}

	@Override
	public boolean canBecomeResolved() {
		return true;
	}
}
