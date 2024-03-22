package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdatePassword {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private AnchorPane updatePasswordContainer;

	@FXML
	private PasswordField inputUpdatePasswordField;

	@FXML
	private PasswordField inputUpdatePasswordConfirmField;

	@FXML
	private Button btnUpdatePassword;

	public void updateUserPassword(ActionEvent event) throws IOException {
		System.out.println("Updated Password!");

		// set to login screen
		root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		double currentWidth = stage.getWidth();
		double currentHeight = stage.getHeight();
		scene = new Scene(root, currentWidth, currentHeight);

		stage.setScene(scene);
		stage.show();
	}
}
