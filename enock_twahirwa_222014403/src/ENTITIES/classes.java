package ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class classes {
	private int classID;
	private String className;
	private String teacherID;

	public classes() {
	}

	public classes(int classID, String className, String teacherID) {
		super();
		this.classID = classID;
		this.className = className;
		this.teacherID = teacherID;

	}

	public classes(String className, String teacherID) {
		this.className = className;
		this.teacherID = teacherID;

	}

	public int getclassID() {
		return classID;
	}

	public void setclassID(int classID) {
		this.classID = classID;
	}

	public String getclassName() {
		return className;
	}

	public void setclassName(String className) {
		this.className = className;
	}

	public String getteacherID() {
		return teacherID;
	}

	public void setteacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public void makeconnnection() throws SQLException {

	}

	public void insertData() {
		// JDBC URL, vehicleclassName, and password of MySQL server
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String vehicle = "222014403";
		String password = "222014403";

		// SQL query to insert data
		String sql = "INSERT INTO classes (className,teacherID) VALUES (?,?)";

		try (
				// Establish the connection
				Connection conn = DriverManager.getConnection(host, vehicle, password);

				// Create a prepared statement
				PreparedStatement user1 = conn.prepareStatement(sql);) {
			// Set the values for the prepared statement
			user1.setString(1, this.className);
			user1.setString(2, this.teacherID);

			// Execute the query
			int rowsAffected = user1.executeUpdate();

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

	public void readwithclassID(int inputclassID) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String username = "222014403";
		String password = "222014403";

		// SQL query to select all columns from customer where classID = ?
		String sql = "SELECT * FROM classes WHERE classID = ?";

		try (
				// Establish the connection
				Connection connnection = DriverManager.getConnection(url, username, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connnection.prepareStatement(sql);) {
			preparedStatement.setInt(1, inputclassID);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.readwithclassID(resultSet.getInt("classID"));
				this.setclassName(resultSet.getString("className"));
				this.setteacherID(resultSet.getString("teacherID"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int inputclassID) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to update data
		String sql = "UPDATE classes SET className = ?,teacherID = ? WHERE classID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement user1 = conn.prepareStatement(sql);) {
			// Set the new values for the update
			user1.setString(1, this.getclassName());
			user1.setString(2, this.getteacherID());

			user1.setInt(3, inputclassID);
			// Execute the update
			int rowsAffected = user1.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data updated successfully!");
				JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to update data. No matching record found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int inputclassID) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String username = "222014403";
		String password = "222014403";

		// SQL query to delete data
		String sql = "DELETE FROM classes WHERE classID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, username, password);

				// Create a prepared statement
				PreparedStatement user1 = conn.prepareStatement(sql);) {
			// Set the value for the WHERE clause
			user1.setInt(1, inputclassID); // Assuming there is a column className 'classID' for the WHERE clause

			// Execute the delete
			int rowsAffected = user1.executeUpdate();

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
