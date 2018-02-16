package WorkflowTask.status;

public abstract class Status {

	public abstract String getName();

	public boolean canBeOpened() {
		return false;
	}

	public boolean canBecomeClosed() {
		return false;
	}

	public boolean canBecomeResolved() {
		return false;
	}

	public boolean canBecomeReopened() {
		return false;
	}

}
