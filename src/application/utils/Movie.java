package Movies;

public class Movie {
    private String movieName;
    private String movieDescription;
    private String movieRating;
    private String movieRealeseDate;
    
    public String getName() {
        return movieName;
    }

    public void setName(String movieDescription) {
        this.movieName = movieDescription;
    }

    public String getDisc() {
        return movieDescription;
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