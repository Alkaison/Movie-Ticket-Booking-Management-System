package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;

public class MovieStatusController implements Initializable{

    @FXML
    private Label movieActors;

    @FXML
    private Label movieAvailableSeat;

    @FXML
    private Label movieDescription;

    @FXML
    private Pane movieImg;

    @FXML
    private Label movieNextShow;

    @FXML
    private Label movieRating;

    @FXML
    private Label movieReleaseDate;

    @FXML
    private Label movieTitle , movieGener;
   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void setMovieData(String name,String gener, String rating, String releaseDate) {
		try {
			
			movieTitle.setText(name);
			movieGener.setText(gener);
			movieRating.setText(rating);
			movieReleaseDate.setText(releaseDate);
			
			System.out.println("Clicked Movie Details:");
			System.out.println("Name: " + name);
			System.out.println("Gener: " + gener);
			System.out.println("Rating: " + rating);
			System.out.println("Release Date: " +releaseDate) ;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    }

}

	

   
