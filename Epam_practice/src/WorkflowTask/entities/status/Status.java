package WorkflowTask.entities.status;

public abstract class Status {

	public abstract String getName();

	public boolean canBecomeAssigned() {
		return false;
	}

	public boolean canBecomeOpened() {
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
