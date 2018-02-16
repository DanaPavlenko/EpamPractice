package WorkflowTask;

import WorkflowTask.status.*;

public class Task {

	private Status status;

	public Task() {
		this.status = new OpenedStatus();
	}

	public Task(Status status) {
		this.status = status;
	}

	public void showStatus() {
		System.out.println("Current status of task is " + status.getName());
	}

	private void changeStatus(Status status) {
		System.out.println("Task changed status from " + this.status.getName() + " to " + status.getName());
		this.status = status;
	}

	private void forbidChangeStatus(Status status) {
		System.out.println("Task status can't be changed from " + this.status.getName() + " to " + status.getName());
	}

	public void setOpenedStatus() {
		if (status.canBeOpened())
			changeStatus(new OpenedStatus());
		else
			forbidChangeStatus(new OpenedStatus());
	}

	public void setClosedStatus() {
		if (status.canBecomeClosed())
			changeStatus(new ClosedStatus());
		else
			forbidChangeStatus(new ClosedStatus());
	}

	public void setResolvedStatus() {
		if (status.canBecomeResolved())
			changeStatus(new ResolvedStatus());
		else
			forbidChangeStatus(new ResolvedStatus());
	}

	public void setReopenedStatus() {
		if (status.canBecomeReopened())
			changeStatus(new ReopenedStatus());
		else
			forbidChangeStatus(new ReopenedStatus());
	}

}
