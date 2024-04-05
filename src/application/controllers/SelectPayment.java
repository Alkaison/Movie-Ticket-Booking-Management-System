package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectPayment implements Initializable {

	@FXML
	private Label MovieTitle;

	@FXML
	private Label Price;

	@FXML
	private Button paymentButton1;

	@FXML
	private Button paymentButton2;

	@FXML
	private Button paymentButton3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setTitleAndPrice();
	}

	// hover animation for cards
	@FXML
	void hover(MouseEvent event) {
		Button button = ((Button)event.getSource());
		button.setStyle("-fx-scale-x: 1.04;");
	}

	// remove hover animation for cards
	@FXML
	void Removehover(MouseEvent event) {
		Button button = ((Button)event.getSource());
		button.setStyle("-fx-scale-x: 1.0;");
	}

	// title and price for movie tickets
	@FXML
	void setTitleAndPrice() {
		// Code for Setting the Movie Title From Database
		MovieTitle.setText("Movie Title");
		Price.setText("Total Amount: Rs XXX/- ");
	}

	@FXML
	void onaction(ActionEvent event) {
		// Page Changing Logic ----
	}
}
