package TEST.ENTITIES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class classesTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM classes ";
		String host = "jdbc:mysql://localhost/enock_twahirwa_nms";
		String user = "222014403";
		String pass = "222014403";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(host, user, pass);
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				// int id =rs.getInt(0);
				String id = rs.getString("classID");
				String vn = rs.getString("classsName");
				String pk = rs.getString("teacherID");

				System.out.println(id + "\t" + vn + "\t" + pk + "\t");
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

// TODO Auto-generated method stub
