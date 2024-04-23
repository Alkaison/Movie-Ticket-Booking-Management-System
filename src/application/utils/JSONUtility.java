package application.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JSONUtility {

	String path_userdata = "rc/application/database/userdata.json";
	String path_moviedata = "rc/application/database/moviedata.json";

	// take ResultSet and store in userdata.json file
	public static void storeUserDataFromResultSet(ResultSet rs) throws IOException, SQLException {
		// Extract user specific data from the ResultSet
		int userId = rs.getInt("id");
		String phoneNumber = rs.getString("phoneNumber");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String cityName = rs.getString("cityName");
		String userEmail = rs.getString("emailAddress");

		// Check for null or empty values and replace with empty string
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			phoneNumber = "";
		}
		if (firstName == null || firstName.isEmpty()) {
			firstName = "";
		}
		if (lastName == null || lastName.isEmpty()) {
			lastName = "";
		}
		if (cityName == null || cityName.isEmpty()) {
			cityName = "";
		}
		if (userEmail == null || userEmail.isEmpty()) {
			userEmail = "";
		}

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

	// check if the userdata.json has userId and email values for auto-login from
	// welcome screen
	public static boolean userIsLoggedIn() {
		// Path to the userdata.json file
		String filePath = "src/application/database/userdata.json";

		// Try-with-resources to automatically close the FileReader
		try (FileReader reader = new FileReader(filePath)) {
			// Parse JSON file
			JsonElement jsonElement = JsonParser.parseReader(reader);
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			// Check if JSON contains userId and email fields
			return jsonObject.has("userId") && !jsonObject.get("userId").isJsonNull() && jsonObject.has("email")
					&& !jsonObject.get("email").isJsonNull() && !jsonObject.get("userId").getAsString().isEmpty()
					&& !jsonObject.get("email").getAsString().isEmpty();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// If user is not found
		return false;
	}

	// remove user details from userdata.json for logout from dashboard
	public static boolean removeValuesAndSave() {
		// Path to the userdata.json file
		String filePath = "src/application/database/userdata.json";

		try {
			// Read JSON file
			FileReader reader = new FileReader(filePath);
			JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
			reader.close();

			// Modify JSON object
			jsonObject.addProperty("userId", "");
			jsonObject.addProperty("email", "");
			jsonObject.addProperty("firstName", "");
			jsonObject.addProperty("lastName", "");
			jsonObject.addProperty("phoneNumber", "");
			jsonObject.addProperty("cityName", "");

			// Write modified JSON back to file
			FileWriter writer = new FileWriter(filePath);
			Gson gson = new Gson();
			gson.toJson(jsonObject, writer);
			writer.close();

			return true; // Modification successful
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false; // Modification failed
	}
	
	public class MovieData {
		public int id, price;
		public String name, timing, booked, selected;
		public String[] bookedSeats, selectedSeats;

		// Constructor
		public MovieData(int id, String name, String timing, String[] booked) {
			this.id = id;
			this.name = name;
			this.timing = timing;
			this.bookedSeats = booked;
		}
	}
	
	//	create and store new movies data into json
	public boolean createMovieJson(int id, String name, String timing, String booked) {
		try {
			FileWriter writer = new FileWriter("src/application/database/moviedata.json");
			Gson gson = new Gson();
			MovieData moviedata = new MovieData(id, name, timing, booked.split(","));
			gson.toJson(moviedata, writer);
			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error storing movie data");
			return false;
		}
	}

	// get movies data from json
	public MovieData getMovieJson(){
		try {
			FileReader reader = new FileReader("src/application/database/moviedata.json");
			Gson gson = new Gson();
			MovieData moviedata = gson.fromJson(reader, MovieData.class);
			reader.close();
			return moviedata;
		} catch (Exception e) {
			System.out.println("Error updating movie data");
			return null;
		}
	}

	//	update movies data into json
	public boolean updateMovieJson(String[] seats, int price) {
		try {
			FileReader reader = new FileReader("src/application/database/moviedata.json");
			Gson gson = new Gson();
			MovieData moviedata = gson.fromJson(reader, MovieData.class);
			reader.close();

			// Updation
			String seatsStr = String.join(", ", seats);
			FileWriter writer = new FileWriter("src/application/database/moviedata.json");
			moviedata.selected = seatsStr;
			moviedata.selectedSeats = seats;
			moviedata.price = price;
			gson.toJson(moviedata, writer);
			writer.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error updating movie data");
			return false;
		}
	}
}
