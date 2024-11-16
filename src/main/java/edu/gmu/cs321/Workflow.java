package edu.gmu.cs321;

import java.util.Queue;
import java.util.PriorityQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Workflow {

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

	public void addWorkflowItemToDB(WorkflowItem wfi) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "cs321";
		String password = "password";

		String sqlInsertQuery = "INSERT INTO testdb (id, firstName, middleName, lastName, dateOfBirth, email, race, gender, requestedDoc, context) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sqlInsertQuery)) {
			pstmt.setString(2, wfi.getForm().getFirstName());
			pstmt.setString(3, wfi.getForm().getMiddleName());
			pstmt.setString(4, wfi.getForm().getLastName());
			pstmt.setDate(5, Date.valueOf(wfi.getForm().getDateOfBirth()));
			pstmt.setString(6, wfi.getForm().getEmail());
			pstmt.setString(7, wfi.getForm().getRace());
			pstmt.setString(8, wfi.getForm().getGender());
			pstmt.setString(9, wfi.getForm().getRequestedDoc());
			pstmt.setString(10, null);
			pstmt.setInt(1, wfi.getForm().getID());

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("New User Added");
			}
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
