package TEST.ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class attendanceTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement fdm = null;
		ResultSet rs = null;
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222104403";
		String pass = "222104403";
		String sql = "SELECT * FROM attendances ";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(host, user, pass);
			fdm = con.prepareStatement(sql);
			rs = fdm.executeQuery();
			while (rs.next()) {

				String id = rs.getString("attendanceID");
				String studentID = rs.getString("studentID");
				String status = rs.getString("status");

				System.out.println(id + "\t" + studentID + "\t" + status);
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
