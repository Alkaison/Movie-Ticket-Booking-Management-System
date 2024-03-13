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

public class ForgotPassword {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private AnchorPane forgotPasswordContainer;

	@FXML
	private TextField inputForgotEmailField;

	@FXML
	private TextField inputForgotOTPField;

	@FXML
	private Button btnSendOTP;

	@FXML
	private Button btnVerifyOTP;

	public void sendOTP(ActionEvent event) {
		System.out.println("Sending OTP");
	}

	public void verifyOTP(ActionEvent event) {
		System.out.println("Verifing OTP");
	}

	public void goToLoginPage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/fxml/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}
}
