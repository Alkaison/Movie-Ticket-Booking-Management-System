package application;

import Movies.Movie;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class movieCardController{


    @FXML
    private AnchorPane anchor;

    @FXML
    private Text setMovieName;

    @FXML
    private Text setMovieRating;

    @FXML
    private Text setMovieReleaseDate;
    
    private MovieCardListener MyListener;
	private Movie movieName;
	
	@FXML
	private void click(MouseEvent event) {
		MyListener.onClick(movieName);
	}
	
//   set to display data to screen
    public void setData(Movie movieName,MovieCardListener MyListener,Movie movieRating) {
    	this.movieName =  movieName;
    	this.MyListener = MyListener;
    	setMovieName.setText(movieName.getName());
    	setMovieRating.setText(movieName.getMovieRating());
//    	setMovieDescription.setText(movieName.getDisc());
    }
    
}
