package edu.gmu.cs321;

public class WorkflowItem {
	private ImmReqForm form;
	private boolean reviewFlag;
	private String context;

	public WorkflowItem(ImmReqForm form, boolean reviewFlag) {
		this.form = form;
		this.reviewFlag = reviewFlag;
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

	public boolean getReviewFlag() {
		return this.reviewFlag;
	}
}
