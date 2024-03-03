package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Login {
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

	public void signUp(ActionEvent e) {
		System.out.println("Sign Up Text Clicked");
	}

	public void forgetPassword(ActionEvent e) {
		System.out.println("Forget Password Text Clicked");
	}
}
