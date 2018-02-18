package WorkflowTask.entities.status;

public class AssignedStatus extends Status {

	@Override
	public String getName() {
		return "Assigned";
	}

	public boolean canBecomeResolved() {
		return true;
	}
}
