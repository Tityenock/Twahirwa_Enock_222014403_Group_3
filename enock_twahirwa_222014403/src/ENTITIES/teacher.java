package ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class teacher {
	private int teacherID;
	private String Firstname;
	private String lastname;
	private String email;
	private String phone;
	private String department;
	private String admin;

	public teacher() {
	}

	public teacher(int teacherID, String Firstname, String lastname, String email, String phone, String department,
			String admin) {
		super();
		this.teacherID = teacherID;
		this.Firstname = Firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.admin = admin;

	}

	public void setadmin(String admin) {
		this.admin = admin;
	}

	public String getadmin() {
		return admin;
	}

	public teacher(String Firstname, String lastname, String email, String phone, String department) {
		this.Firstname = Firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.department = department;
	}

	public int getteacherID() {
		return teacherID;
	}

	public void setteacherID(int teacherID) {
		this.teacherID = teacherID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getdepartment() {
		return department;
	}

	public void setdepartment(String department) {
		this.department = department;
	}

	public void makeconnnection() {

	}

	public void insertDataa() {
		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to insert data
		String sql = "INSERT INTO teachers (Firstname,lastname, email,phone,department,adminID) VALUES (?, ?, ?, ?,?,?)";

		try (
				// Establish the connnection
				Connection conn = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement custm = conn.prepareStatement(sql);) {
			// Set the values for the prepared statement
			custm.setString(1, this.Firstname);
			custm.setString(2, this.lastname);
			custm.setString(3, this.email);
			custm.setString(4, this.phone);
			custm.setString(5, this.department);
			custm.setString(6, this.admin);

			// Execute the query
			int rowsAffected = custm.executeUpdate();

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
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readwithteacherID(int inputteacherID) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to select all columns from teacher where teacherID = ?
		String sql = "SELECT * FROM teachers WHERE teacherID = ?";

		try (
				// Establish the connnection
				Connection connnection = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connnection.prepareStatement(sql);) {
			// Set the value for the parameterized query
			// int teachersteacherID = 1; // Replace with the desired teacher teacherID
			// if()
			preparedStatement.setInt(1, inputteacherID);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.readwithteacherID(resultSet.getInt("teacherID"));
				this.setlastname(resultSet.getString("Firstname"));
				this.setFirstname(resultSet.getString("lastname"));
				this.setEmail(resultSet.getString("email"));
				this.setphone(resultSet.getString("phone"));
				this.setdepartment(resultSet.getString("department"));
				this.setadmin(resultSet.getString("adminID"));

			}
			connnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int inputteacherID) {
		// JDBC URL, fuel_delivery_app_management_project, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to update data
		String sql = "UPDATE teachers SET  Firstname = ?,lastname = ?,email = ?,phone = ?, department=?,adminID=? WHERE teacherID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement custm = conn.prepareStatement(sql);) {
			// Set the new values for the update
			custm.setString(1, this.getFirstname());
			custm.setString(2, this.getlastname());
			custm.setString(3, this.getEmail()); // Assuming there is a column named 'teacherID' for the WHERE clause
			custm.setString(4, this.getphone());
			custm.setString(5, this.getdepartment());
			custm.setString(6, this.getadmin());
			custm.setInt(7, inputteacherID);
			// Execute the update
			int rowsAffected = custm.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data updated successfully!");
				JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to update data. No matching record found.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int inputteacherID) {
		// JDBC URL, fuel_delivery_app_management_project, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String password = "222014403";

		// SQL query to delete data
		String sql = "DELETE FROM teachers WHERE teacherID = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user, password);

				// Create a prepared statement
				PreparedStatement custm = conn.prepareStatement(sql);) {
			// Set the value for the WHERE clause
			custm.setInt(1, inputteacherID); // Assuming there is a column named 'teacherID' for the WHERE clause

			// Execute the delete
			int rowsAffected = custm.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data deleted successfully!");
				JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to delete data. No matching record found.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
