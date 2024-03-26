package application.utils;

public class Movie {
    private String movieName;
    private String movieDescription;
    private String movieRating;
    private String movieRealeseDate , movieGener;
    

	public String getName() {
        return movieName;
    }

    public void setName(String movieDescription) {
        this.movieName = movieDescription;
    }

    public String getDisc() {
        return movieDescription;
    }

    public String getMovieGener() {
    	return movieGener;
    }
    
    public void setMovieGener(String movieGener) {
    	this.movieGener = movieGener;
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

    public void setDisc(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}