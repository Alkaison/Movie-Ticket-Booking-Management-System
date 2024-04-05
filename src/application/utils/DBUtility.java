package application.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.sqlite.SQLiteDataSource;

public class DBUtility {

	private static final String DB_URL = "jdbc:sqlite:src/application/database/movie_ticket_booking.db";

	// validate login, encrypt password and store data in userdata.json
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
					JSONUtility.storeUserDataFromResultSet(rs);
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

	// check if the user account already exists via EmailAddress
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

	// update users password, encrpyt password
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
			return rowsUpdated > 0;
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

	// create new account, parse FullName, ecnrypt password
	public static Boolean createNewUserAccount(String fullName, String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl(DB_URL);

			conn = ds.getConnection();

			// Encrypt password
			String encryptedPassword = EncryptionDecryption.encrypt(password);

			// Split the full name into first and last names
			String[] parsedName = Form.parseFullName(fullName);
			String firstName = (parsedName != null && parsedName.length > 0) ? parsedName[0] : null;
			String lastName = (parsedName != null && parsedName.length > 1) ? parsedName[1] : null;

			String insertQuery = "INSERT INTO USERS (firstName, lastName, emailAddress, password) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertQuery);

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, email);
			pstmt.setString(4, encryptedPassword);

			// Execute the insert query
			int rowsInserted = pstmt.executeUpdate();

			// Check if the insert was successful
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Return false in case of any exception
		} finally {
			try {
				// Close PreparedStatement and Connection
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	Fetch Movies Table data
public static void getMoviesData(ResultSet rs, List<Movie> movies) {
	try {
		while (rs.next()) {
			String getMovieName = rs.getString("name");
			String getMovieDescription = rs.getString("description");
			String getMovieRating = rs.getString("ratings");
			String getMovieGener = rs.getString("gener");
			String getMovieRealeseDateTime = rs.getString("releaseDate");
			int getBoookedSeat = rs.getInt("bookedSeatsCount");
			int getTotalSeat = rs.getInt("totalNumberOfSeats");
			String getNextShow = rs.getString("showDatesAndTimings");

			SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MM-yyyy");
			String getMovieRealeseDate = sdfOutput.format(sdfInput.parse(getMovieRealeseDateTime.toString()));
			
			Movie movie = new Movie();
			movie.setMovieName(getMovieName);
			movie.setMovieDescription(getMovieDescription);
			movie.setMovieRating(getMovieRating);
			movie.setMovieGener(getMovieGener);
			movie.setMovieRealeseDate(getMovieRealeseDate);
			movie.setBookedSeat(getBoookedSeat);
			movie.setTotalSeat(getTotalSeat);
			movie.setNextShow(getNextShow);

			
			movies.add(movie);
		}
	} catch (Exception e) {
		System.out.println(e.toString());
	}
}
}
