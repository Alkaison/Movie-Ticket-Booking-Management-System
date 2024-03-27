package application.utils;

public class Movie {
    private String movieName, movieDescription;
    private String movieRating;
    private String movieRealeseDate , movieGener;
    private String NextShow;
    private int BoookedSeat , TotalSeat;
	private int availableSeat;
    
	public String getMovieName() {
		return movieName;
	}
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
	public void setNextShow(String getNextShow) {
		this.NextShow = getNextShow;
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
		return availableSeat ;
	}
	public void setAvailableSeat(int totalSeat , int bookedSeat) {
		availableSeat = totalSeat - bookedSeat;
	}
		
}