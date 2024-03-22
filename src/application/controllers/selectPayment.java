package application.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;


public class selectPayment implements Initializable{

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

    @FXML
    void hover(MouseEvent event) {
        paymentButton1.setOnMouseEntered(event1 -> paymentButton1.setStyle("-fx-scale-x: 1.1;"));
        paymentButton2.setOnMouseEntered(event1 -> paymentButton2.setStyle("-fx-scale-x: 1.1;"));
        paymentButton3.setOnMouseEntered(event1 -> paymentButton3.setStyle("-fx-scale-x: 1.1;"));
    }

    @FXML
    void Removehover(MouseEvent event) {
        paymentButton1.setOnMouseExited(event1 -> paymentButton1.setStyle("-fx-scale-x: 1.0;"));
        paymentButton2.setOnMouseExited(event1 -> paymentButton2.setStyle("-fx-scale-x: 1.0;"));
        paymentButton3.setOnMouseExited(event1 -> paymentButton3.setStyle("-fx-scale-x: 1.0;"));
    }

    @FXML
    void setTitleAndPrice() {
        // Code for Setting the  Movie Title From Database
        MovieTitle.setText("Movie Title");
        Price.setText("Total Amount: Rs XXX/- ");
    }

    @FXML
    void onaction(ActionEvent event) {
        // Page Changing Logic ----
    }
}



