package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UpdatePassword {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private AnchorPane updatePasswordContainer;

	@FXML
	private TextField inputUpdatePasswordField;

	@FXML
	private TextField inputUpdatePasswordConfirmField;

	@FXML
	private Button btnUpdatePassword;

	public void updateUserPassword(ActionEvent event) throws IOException {
		System.out.println("Updated Password!");

		// set to login screen
		root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}
}
