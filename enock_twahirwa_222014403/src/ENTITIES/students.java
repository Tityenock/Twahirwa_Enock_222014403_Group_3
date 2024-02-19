package ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class students {
	private int studentID;
	private String Firstname;
	private String lastname;
	private String DateOFBirth;
	private String teacherID;

	public students() {
	}

	public students(int studentID, String Firstname, String lastname, String DateOFBirth, String teacherID) {
		super();
		this.studentID = studentID;
		this.Firstname = Firstname;
		this.lastname = lastname;
		this.DateOFBirth = DateOFBirth;
		this.teacherID = teacherID;

	}

	public students(String Firstname, String lastname, String DateOFBirth, String teacherID) {
		this.Firstname = Firstname;
		this.lastname = lastname;
		this.DateOFBirth = DateOFBirth;
		this.teacherID = teacherID;

	}

	public int getstudentID() {
		return studentID;
	}

	public void setstudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOFBirth() {
		return DateOFBirth;
	}

	public void setDateOFBirth(String DateOFBirth) {
		this.DateOFBirth = DateOFBirth;
	}

	public String getteacherID() {
		return teacherID;
	}

	public void setteacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public void makeconnnection() {

	}

	public void insertDataa() {
		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to insert data
		String sql = "INSERT INTO students (Firstname,lastname, DateOFBirth,teacherID) VALUES (?, ?, ?, ?)";

		try (
				// Establish the connnection
				Connection conn = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stud = conn.prepareStatement(sql);) {
			// Set the values for the prepared statement
			stud.setString(1, this.Firstname);
			stud.setString(2, this.lastname);
			stud.setString(3, this.DateOFBirth);
			stud.setString(4, this.teacherID);

			// Execute the query
			int rowsAffected = stud.executeUpdate();

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

	public void readwithstudentID(int inputstudentID) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to select all columns from students where studentID = ?
		String sql = "SELECT * FROM students WHERE studentID = ?";

		try (
				// Establish the connnection
				Connection connnection = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connnection.prepareStatement(sql);) {
			// Set the value for the parameterized query
			// int studentssstudentID = 1; // Replace with the desired students studentID
			// if()
			preparedStatement.setInt(1, inputstudentID);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.readwithstudentID(resultSet.getInt("studentID"));
				this.setFirstname(resultSet.getString("Firstname"));
				this.setlastname(resultSet.getString("lastname"));
				this.setDateOFBirth(resultSet.getString("DateOFBirth"));
				this.setteacherID(resultSet.getString("teacherID"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int inputstudentID) {
		// JDBC URL, fuel_delivery_app_management_project, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to update data
		String sql = "UPDATE students SET Firstname = ?,lastname = ?,DateOFBirth = ?,teacherID = ? WHERE studentID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement stud = conn.prepareStatement(sql);) {
			// Set the new values for the update
			stud.setString(1, this.getFirstname());
			stud.setString(2, this.getlastname());
			stud.setString(3, this.getDateOFBirth()); // Assuming there is a column named 'studentID' for the WHERE
														// clause
			stud.setString(4, this.getteacherID());

			stud.setInt(5, inputstudentID);
			// Execute the update
			int rowsAffected = stud.executeUpdate();

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

	public void delete(int inputstudentID) {
		// JDBC URL, fuel_delivery_app_management_project, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to delete data
		String sql = "DELETE FROM students WHERE studentID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement stud = conn.prepareStatement(sql);) {
			// Set the value for the WHERE clause
			stud.setInt(1, inputstudentID); // Assuming there is a column named 'studentID' for the WHERE clause

			// Execute the delete
			int rowsAffected = stud.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data deleted successfully!");
				JOptionPane.showMessageDialog(null, "Data deletedsuccessfully!", "After delete",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to delete data. No matching record found.");
			}

		} catch (SQLException e) {
			System.out.println("Cannot delete. It is referenced by other records.");
			// Optionally, you can log the exception or take other actions
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}
