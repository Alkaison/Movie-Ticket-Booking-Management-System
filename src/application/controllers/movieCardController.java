package application;

import Movies.Movie;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MovieCardController{
	
	@FXML
    private AnchorPane MovieImgContainer , anchor;
	@FXML
	private Text setMovieName;
	@FXML
	private Text setMovieGener, setMovieRating, setMovieReleaseDate;
	@FXML
	private Movie movieName;

    @FXML
    private ImageView setMovieImg;
    private MovieCardListener MyListener;
    
	@FXML
	private void click(MouseEvent event) {
		MyListener.onClick(movieName);
	}
	
//   set to display data to screen
    public void setData(Movie movieName,MovieCardListener MyListener,Movie movieRating, Movie movieGener , Movie movieReleaseDate) {
    	this.movieName =  movieName;
    	this.MyListener = MyListener;
    	setMovieName.setText(movieName.getName());
    	setMovieRating.setText(movieName.getMovieRating());
    	setMovieGener.setText(movieName.getMovieGener());
    	setMovieReleaseDate.setText(movieName.getMovieRealeseDate());
    }
    
}
