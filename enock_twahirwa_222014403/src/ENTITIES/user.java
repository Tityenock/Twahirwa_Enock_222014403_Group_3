package ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class user {

	private int id;
	private String username;
	private String password;
	private String role;

	public user() {
	}

	public user(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}

	public void makeconnnection() {

	}

	public void insertData() {
		// JDBC URL, user, and password of MySQL server
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password ="222014403";

		// SQL query to insert data
		String sql = "INSERT INTO users ( username, password, role) VALUES (?, ?, ?)";

		try (
				// Establish the connection
				Connection conn = DriverManager.getConnection(host, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the values for the prepared statement
			user.setString(1, this.username);
			user.setString(2, this.password);
			user.setString(3, this.role);

			// Execute the query
			int rowsAffected = user.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {

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

	public void readwithid(int inputid) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password ="222014403";

		// SQL query to select all columns from user where id = ?
		String sql = "SELECT * FROM users WHERE id = ?";

		try (
				// Establish the connection
				Connection connnection = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connnection.prepareStatement(sql);) {

			preparedStatement.setInt(1, inputid);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.readwithid(resultSet.getInt("id"));
				this.setusername(resultSet.getString("username"));
				this.setpassword(resultSet.getString("password"));
				this.setrole(resultSet.getString("role"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int inputid) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password ="222014403";

		// SQL query to update data
		String sql = "UPDATE users SET username = ?,password = ?,role=? WHERE id = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the new values for the update
			user.setString(1, this.getusername());
			user.setString(2, this.getpassword());
			user.setString(3, this.getrole());

			user.setInt(4, inputid);
			// Execute the update
			int rowsAffected = user.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {

				JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to update data. No matching record found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int inputid) {
		// JDBC URL, user, and password of MySQL server
		String url = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user1 = "222014403";
		String password ="222014403";

		// SQL query to delete data
		String sql = "DELETE FROM users WHERE id = ?";

		try (
				// Establish the conn
				Connection conn = DriverManager.getConnection(url, user1, password);

				// Create a prepared statement
				PreparedStatement user = conn.prepareStatement(sql);) {
			// Set the value for the WHERE clause
			user.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

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
