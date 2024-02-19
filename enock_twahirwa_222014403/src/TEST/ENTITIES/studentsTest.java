package TEST.ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentsTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement fdm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM students ";
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String pass = "222014403";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(host, user, pass);
			fdm = con.prepareStatement(sql);
			rs = fdm.executeQuery();
			while (rs.next()) {

				String studentID = rs.getString("studentID");
				String Firstname = rs.getString("Firstname");
				String lastname = rs.getString("lastname");
				String DateOFBirth = rs.getString("DateOFBirth");
				String teacherID = rs.getString("teacherID");

				System.out.println(
						studentID + "\t" + Firstname + "\t" + lastname + "\t" + DateOFBirth + "\t" + teacherID + "\t");
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
