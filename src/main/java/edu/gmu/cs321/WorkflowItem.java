package edu.gmu.cs321;

public class WorkflowItem {
	private ImmReqForm form;
	private String context;

	public WorkflowItem(ImmReqForm form) {
		this.form = form;
	}

	public void addContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public ImmReqForm getForm() {
		return this.form;
	}
}
