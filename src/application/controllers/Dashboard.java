package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Dashboard implements Initializable {

	@FXML
	private GridPane dashboardGrid;

	@FXML
	private AnchorPane dashboardAnchoreContainer;

	@FXML
	private HBox dashboardContentHboxContainer;

	@FXML
	private Button dashboardBtn;

	@FXML
	private Button moviesBtn;

	@FXML
	private Button bookingsBtn;

	@FXML
	private Button usersBtn;

	@FXML
	private Button logoutBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Analytics.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handlePageChangeBtnClick(ActionEvent event) throws IOException {
		// Get the source of the event
		Button clickedButton = (Button) event.getSource();

		// Perform different actions based on the clicked button
		if (clickedButton == dashboardBtn) {
			// Handle dashboard button click
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Analytics.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		} else if (clickedButton == moviesBtn) {
			// Handle movies button click
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Movies.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		} else if (clickedButton == bookingsBtn) {
			// Handle bookings button click
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Bookings.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		} else if (clickedButton == usersBtn) {
			// Handle users button click
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Users.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		} else if (clickedButton == logoutBtn) {
			// Handle logout button click
			Parent fxml = FXMLLoader.load(getClass().getResource("/application/fxml/Logout.fxml"));
			dashboardContentHboxContainer.getChildren().removeAll();
			dashboardContentHboxContainer.getChildren().setAll(fxml);
		}
	}

	@FXML
	public void hoverBtn(MouseEvent event) {
		Button button = ((Button)event.getSource());
		button.setStyle("-fx-scale-x: 1.04;");
	}

	@FXML
	public void unhoverBtn(MouseEvent event) {
		Button button = ((Button)event.getSource());
		button.setStyle("-fx-scale-x: 1.0;");
	}

}
