package application.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JSONUtility {

	public static void storeUserData(ResultSet rs) throws IOException, SQLException {
		// Extract user specific data from the ResultSet
		int userId = rs.getInt("id");
		String phoneNumber = rs.getString("phoneNumber");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String cityName = rs.getString("cityName");
		String userEmail = rs.getString("emailAddress");

		// Create Gson object
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Create User object
		User user = new User(userId, firstName, lastName, userEmail, phoneNumber, cityName);

		// Convert User object to JSON string
		String jsonString = gson.toJson(user);

		// Write JSON string to file
		try (FileWriter writer = new FileWriter("src/application/database/userdata.json")) {
			writer.write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Inner class representing User
	static class User {
		public int userId; // Make the field public
		String firstName, lastName, email, phoneNumber, cityName;

		// Constructor
		public User(int id, String fname, String lname, String email, String phoneNumber, String cityName) {
			this.userId = id;
			this.firstName = fname;
			this.lastName = lname;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.cityName = cityName;
		}
	}

}
