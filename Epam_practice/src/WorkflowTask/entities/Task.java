package WorkflowTask.entities;

import WorkflowTask.entities.status.*;

public class Task {

	private String name;

	private Status status;

	public Task(String name) {
		this.name = name;
		this.status = new OpenedStatus();
	}

	public Task(String name, Status status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", status=" + status.getName() + "]";
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
		if (status.canBecomeOpened())
			changeStatus(new OpenedStatus());
		else
			forbidChangeStatus(new OpenedStatus());
	}

	public void setAssignedStatus() {
		if (status.canBecomeAssigned())
			changeStatus(new AssignedStatus());
		else
			forbidChangeStatus(new AssignedStatus());
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
