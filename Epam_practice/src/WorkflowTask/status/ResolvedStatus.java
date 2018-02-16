package WorkflowTask.status;

public class ResolvedStatus extends Status {

	public String getName() {
		return "Resolved";
	}

	@Override
	public boolean canBecomeClosed() {
		return true;
	}

}
