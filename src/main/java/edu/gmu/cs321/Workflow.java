package edu.gmu.cs321;

import java.util.Queue;
import java.util.LinkedList;	

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Workflow {

	private Queue<WorkflowItem> queue;
	String mySqlUrl;
	String mySqlUsername;
	String mySqlPassword;

	private void handleSQLException(SQLException e) {
	    System.out.println("SQLException: " + e.getMessage());
	    System.out.println("SQLState: " + e.getSQLState());
	    System.out.println("VendorError: " + e.getErrorCode());
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(mySqlUrl, mySqlUsername, mySqlPassword);
	}

	private void fillQueue() {
		String sqlGetDataQuery = "SELECT * FROM testdb";

		try (Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlGetDataQuery)) {
		while (rs.next()) {
			this.addNewWorkflowItem(new WorkflowItem(new ImmReqForm(
							rs.getString("firstName"),
							rs.getString("middleName"),
							rs.getString("lastName"),
							rs.getDate("dateOfBirth").toLocalDate(),
							rs.getInt("id"),
							rs.getString("email"),
							rs.getString("race"),
							rs.getString("gender"),
							rs.getString("requestedDoc")),rs.getBoolean("reviewFlag")));
		}
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	public void dropImmReqForm(int ID) {
		String deleteQuery = "DELETE FROM testdb WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(mySqlUrl, mySqlUsername, mySqlPassword);
				PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

		pstmt.setInt(1, ID);
		int rowsAffected = pstmt.executeUpdate();
		System.out.printf("ID PASSED: %d\n# of ROWS DELETED: %d\n", ID, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Workflow() {
		this.queue = new LinkedList<WorkflowItem>();

		this.mySqlUrl = "jdbc:mysql://localhost:3306/testdb";
		this.mySqlUsername = "cs321";
		this.mySqlPassword = "password";
		fillQueue();
	}

	public void addNewWorkflowItem(WorkflowItem wfi) {
		this.queue.add(wfi);
	}

	public WorkflowItem getNextWorkflowItem() {
		return this.queue.poll();
	}

	public void addWorkflowItemToDB(WorkflowItem wfi) {
		String sqlInsertQuery = "INSERT INTO testdb (id, firstName, middleName, lastName, dateOfBirth, email, race, gender, requestedDoc, reviewFlag, context) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlInsertQuery)) {
			pstmt.setString(2,wfi.getForm().getFirstName());
			pstmt.setString(3,wfi.getForm().getMiddleName());
			pstmt.setString(4,wfi.getForm().getLastName());
			pstmt.setDate(5, Date.valueOf(wfi.getForm().getDateOfBirth()));
			pstmt.setString(6,wfi.getForm().getEmail());
			pstmt.setString(7,wfi.getForm().getRace());
			pstmt.setString(8,wfi.getForm().getGender());
			pstmt.setString(9,wfi.getForm().getRequestedDoc());
			pstmt.setBoolean(10,wfi.getReviewFlag());
			pstmt.setString(11,null);
			pstmt.setInt(1, wfi.getForm().getID());

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("New User Added");
			}
		} catch (SQLException e) {
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		    throw new IllegalStateException("Database error");
		}
	}

}
