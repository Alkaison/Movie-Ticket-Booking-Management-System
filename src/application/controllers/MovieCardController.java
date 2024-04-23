package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.utils.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovieCardController{

	Stage stage;
	Scene scene;

	@FXML
	private AnchorPane MovieImgContainer, anchor;

	@FXML
	private Text setMovieName;

	@FXML
	private Text setMovieGener, setMovieRating, setMovieReleaseDate;

	@FXML
	private Movie movie;

	@FXML
	private ImageView setMovieImg;

	@FXML
	private void click(MouseEvent e) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/fxml/MovieStatus.fxml"));
		Parent root = loader.load();
		MovieStatusController controller = loader.getController();

		// Pass the movie details to MovieStatusController
		controller.setMovieData(setMovieName.getText(), setMovieGener.getText(), setMovieRating.getText(),
				setMovieReleaseDate.getText());

		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		double currentWidth = stage.getWidth();
		double currentHeight = stage.getHeight();
		Scene scene = new Scene(root, currentWidth, currentHeight);
		stage.setScene(scene);
		stage.show();
	}

//   set to display data to screen
	public void setData(Movie movie) {
	    Image moviePoster = (Image) movie.getMoviePoster();
	    
	    setMovieImg.setImage(moviePoster);
//	    setMovieImg.setFitWidth(300); // Set the width as per your requirement
//	    setMovieImg.setFitHeight(400); // Set the height as per your requirement
//	    setMovieImg.setOpacity(1); 
	    

	    setMovieName.setText(movie.getMovieName());
	    setMovieRating.setText(movie.getMovieRating());
	    setMovieGener.setText(movie.getMovieGener());
	    setMovieReleaseDate.setText(movie.getMovieRealeseDate());
	}

}
