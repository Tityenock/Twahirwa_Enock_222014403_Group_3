package TEST.ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement fdm = null;
		ResultSet rs = null;
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String pass = "222014403";
		String sql = "SELECT * FROM users ";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(host, user, pass);
			fdm = con.prepareStatement(sql);
			rs = fdm.executeQuery();
			while (rs.next()) {

				String id = rs.getString("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");

				System.out.println(id + "\t" + username + "\t" + password + "\t" + role);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("An error occurred while loading the JDBC driver");
		} catch (SQLException e) {
			System.out.println("There was an error accessing the database.");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("There was an error accessing the database.");
			}
		}

	}

}
