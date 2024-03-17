package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

// run this SqlTest program, to check the installation process of the SQLite + JavaFX 
public class SqlTest {
	public static void main(String[] args) {
		SQLiteDataSource ds = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:src/application/database/movie_ticket_booking.db");

			conn = ds.getConnection();
			stmt = conn.createStatement();

			System.out.println("Opened database successfully");
			System.out.println("Selecting all rows from USERS table");

			String query = "SELECT * FROM USERS";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("firstName");

				System.out.println("Result: ID = " + id + ", NAME = " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources in finally block to ensure they are always closed
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
