package application.utils;

import java.sql.*;

import org.sqlite.SQLiteDataSource;

public class DBUtility {

	private static final String DB_URL = "jdbc:sqlite:src/application/database/movie_ticket_booking.db";

	public static Boolean validateLogin(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// encrypt password
		String encryptedPassword = EncryptionDecryption.encrypt(password);

		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl(DB_URL);

			conn = ds.getConnection();

			String query = "SELECT * FROM USERS WHERE emailAddress = ? AND password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, encryptedPassword);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// If any row is returned, login is valid
				// Store user specific data in a file
				try {
					JSONUtility.storeUserData(rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false in case of any exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Boolean checkExistinguserEmailAddress(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl(DB_URL);

			conn = ds.getConnection();

			String query = "SELECT * FROM USERS WHERE emailAddress = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// If any row is returned, email is valid
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false in case of any exception
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Boolean updateUsersPassword(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl(DB_URL);

			conn = ds.getConnection();

			// encrypt password
			String encryptedPassword = EncryptionDecryption.encrypt(password);

			String updateQuery = "UPDATE USERS SET password = ? WHERE emailAddress = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, encryptedPassword);
			pstmt.setString(2, email);

			// Execute the update query
			int rowsUpdated = pstmt.executeUpdate();

			// Check if the update was successful
			if (rowsUpdated > 0) {
				// Password updated successfully
				return true;
			} else {
				// No rows were updated, possibly due to no user with the given email
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false in case of any exception
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
