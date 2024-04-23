package application.utils;

import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class Movie {
	private String movieName, movieDescription;
	private String movieRating;
	private String movieRealeseDate, movieGener;
	private String NextShow, Actor, moviePosterPath;
	private int BoookedSeat, TotalSeat;
	private int availableSeat;

	public String getMovieName() {
		return movieName;
	}

	// Method to validate the URL
	@SuppressWarnings("deprecation")
	private boolean isValidUrl(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (MalformedURLException | java.net.URISyntaxException e) {
			return false;
		}
	}

	public void setMoviePoster(String moviePosterPath) {
		boolean isValidUrl = isValidUrl(moviePosterPath);

		if (isValidUrl) {
			this.moviePosterPath = moviePosterPath;
		} else {
			this.moviePosterPath = "";
		}
	}

	// Method to load image from URL
	public Image loadImageFromUrl(String imageUrl) {
		if (!isValidUrl(imageUrl)) {
			System.err.println("Invalid URL: " + imageUrl);
			return null;
		}

		try {
			// Open a stream from the URL
			@SuppressWarnings("deprecation")
			InputStream inputStream = new URL(imageUrl).openStream();

			// Read the bytes from the stream
			byte[] bytes = inputStream.readAllBytes();

			// Close the stream
			inputStream.close();

			// Create an image from the byte array
			return new Image(new ByteArrayInputStream(bytes));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Image getMoviePoster() {
		Image image = loadImageFromUrl(moviePosterPath);
		return image;
	}
	
//	public ImageView getMoviePoster() {
//	    Image image = loadImageFromUrl(moviePosterPath);
//	    ImageView imageView = new ImageView(image);
//	    
//	    // Set preserveRatio to false to allow setting fixed width and height
//	    imageView.setPreserveRatio(false);
//	    
//	    // Set the desired width and height
//	    imageView.setFitWidth(200); // Set the width as per your requirement
//	    imageView.setFitHeight(300); // Set the height as per your requirement
//	    
//	    // Set the anchor plan (position of the image within the ImageView)
////	    imageView.setAnchor(Anchor.CENTER); // Change CENTER to the desired anchor position
//	    
//	    return imageView;
//	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieRealeseDate() {
		return movieRealeseDate;
	}

	public void setMovieRealeseDate(String movieRealeseDate) {
		this.movieRealeseDate = movieRealeseDate;
	}

	public String getMovieGener() {
		return movieGener;
	}

	public void setMovieGener(String movieGener) {
		this.movieGener = movieGener;
	}

	public String getNextShow() {
		return NextShow;
	}

	public void setNextShow(String NextShow) {
		this.NextShow = NextShow;
	}

	public int getBookedSeat() {
		return BoookedSeat;
	}

	public void setBookedSeat(int getBoookedSeat) {
		this.BoookedSeat = getBoookedSeat;
	}

	public int getTotalSeat() {
		return TotalSeat;
	}

	public void setTotalSeat(int getTotalSeat) {
		this.TotalSeat = getTotalSeat;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int totalSeat, int bookedSeat) {
		availableSeat = totalSeat - bookedSeat;
	}

	public String getMovieActor() {
		return Actor;
	}

	public void setMovieActor(String Actor) {
		this.Actor = Actor;
	}
}