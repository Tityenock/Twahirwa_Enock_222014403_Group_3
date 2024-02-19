package ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class attendances {

	private int attendanceID;
	private String studentID;
	private String action;

	public attendances() {
	}

	public attendances(int attendanceID, String studentID, String action) {
		super();
		this.attendanceID = attendanceID;
		this.studentID = studentID;
		this.action = action;

	}

	public void setaction(String action) {
		this.action = action;
	}

	public String getaction() {
		return action;
	}

	public int getattendanceID() {
		return attendanceID;
	}

	public void setattendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getstudentID() {
		return studentID;
	}

	public void setstudentID(String studentID) {
		this.studentID = studentID;
	}

	public void makeconnnection() {

	}

	public void insertData() {
		// JDBC URL, user, and password of MySQL server
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password = "222014403";

		// SQL query to insert data
		String sql = "INSERT INTO attendances(attendanceID,studentID,status) VALUES (?,?,?)";

		try (
				// Establish the connection
				Connection conn = DriverManager.getConnection(host, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the values for the prepared statement
			user.setInt(1, this.attendanceID);
			user.setString(2, this.studentID);
			user.setString(3, this.action);

			// Execute the query
			int rowsAffected = user.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data inserted successfully!");
				JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to insert data.");
				JOptionPane.showMessageDialog(null, "Failed to insert data.!", "After insert",
						JOptionPane.ERROR_MESSAGE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readwithattendanceID(int inputattendanceID) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password = "222014243";

		// SQL query to select all columns from user where id = ?
		String sql = "SELECT * FROM attendances WHERE attendanceID = ?";

		try (
				// Establish the connection
				Connection connnection = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connnection.prepareStatement(sql);) {

			preparedStatement.setInt(1, inputattendanceID);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.readwithattendanceID(resultSet.getInt("attendanceID"));
				this.setstudentID(resultSet.getString("studentID"));
				this.setaction(resultSet.getString("status"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int inputattendanceID) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password = "222014243";

		// SQL query to update data
		String sql = "UPDATE attendances SET studentID = ?,status =? WHERE attendanceID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the new values for the update
			user.setString(1, this.getstudentID());
			user.setString(2, this.getaction());

			user.setInt(3, inputattendanceID);
			// Execute the update
			int rowsAffected = user.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data updated successfully!");
				JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to update data. No matching record found.");
			}

		} catch (SQLException e) {
			System.out.println("Cannot delete the user. It is referenced by other records.");
			// Optionally, you can log the exception or take other actions
			e.printStackTrace();
			e.printStackTrace();
		}
	}

	public void delete(int inputattendanceID) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password = "222014243";

		// SQL query to delete data
		String sql = "DELETE FROM attendances WHERE attendanceID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the value for the WHERE clause
			user.setInt(1, inputattendanceID);
			// Execute the delete
			int rowsAffected = user.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data deleted successfully!");
				JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to delete data. No matching record found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
