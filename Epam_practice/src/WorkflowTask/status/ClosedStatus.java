package WorkflowTask.status;

public class ClosedStatus extends Status {

	public String getName() {
		return "Closed";
	}

	@Override
	public boolean canBecomeReopened() {
		return true;
	}

}
