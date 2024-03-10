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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private AnchorPane loginFormContainer;

	@FXML
	private TextField inputLoginEmailField;

	@FXML
	private PasswordField inputLoginPasswordField;

	@FXML
	private Button btnLogin;

	public void login(ActionEvent e) {
		String emailAddress = inputLoginEmailField.getText();
		String password = inputLoginPasswordField.getText();

		System.out.println("Login Button Clicked");
		System.out.println("Email Address: " + emailAddress);
		System.out.println("Password: " + password);
	}

	public void signUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/fxml/SignUp.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

	public void forgetPassword(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/fxml/ForgotPassword.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

}
