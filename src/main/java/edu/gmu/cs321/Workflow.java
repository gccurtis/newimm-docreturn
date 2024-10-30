package edu.gmu.cs321;

import java.util.Queue;
import java.util.PriorityQueue;	

public class Workflow {

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

	private Queue<WorkflowItem> queue;

	public Workflow() {
		this.queue = new PriorityQueue<WorkflowItem>(1000);
	}

	public void addNewWorkflowItem(WorkflowItem wfi) {
		this.queue.add(wfi);
	}

	public void addImmReqForm(ImmReqForm form) {
		this.queue.add(new WorkflowItem(form));
	}

	public WorkflowItem getNextWorkflowItem() {
		return this.queue.poll();
	}

}
