package application.controllers;

import application.utils.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovieCardController {

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
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

//   set to display data to screen
	public void setData(Movie movie) {
		setMovieName.setText(movie.getMovieName());
		setMovieRating.setText(movie.getMovieRating());
		setMovieGener.setText(movie.getMovieGener());
		setMovieReleaseDate.setText(movie.getMovieRealeseDate());
	}
}
