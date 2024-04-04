package application.controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SelectSeats implements Initializable {
	
	public String selectedSeats[] = {};

	@FXML
//	private GridPane selectSeatsWrap;
	private AnchorPane seatsPane;
//	private ScrollPane seatsPane;
	
	public String getSeatCode(int num) {
		char[] chs = new char[10];
        char startChar = 'A';
        for (int i = 0; i < chs.length; i++) {
            chs[i] = (char)(startChar + i);
        }
        String st2 = Character.toString(chs[num%10]);
		String str = Integer.toString(num/10 + 1) + st2;
		return str;
	}
	
	public int getSeatNumber(String seatCode) {
		char[] chs = new char[10];
        char startChar = 'A';
        for (int i = 0; i < chs.length; i++) {
            chs[i] = (char)(startChar + i);
        }
        int seatCol = -1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == seatCode.toCharArray()[1]) {
                seatCol= i;
                break;
            }
        }
        int seatRow = (Integer.parseInt(seatCode.substring(0, 1)) - 1) * 10;
		int seatNum = seatRow + seatCol;
		return seatNum;
	}
	
	public String[] getUpdatedSelection(String[] orgArr, int method, String el) {
		String[] newArr = {};
		// Addition of Seat
		if(method == 1) {
			newArr = Arrays.copyOf(orgArr, orgArr.length+1);
			newArr[orgArr.length] = el;
		}
		// Removal of Seat
		if(method == 0) {
			for (int i = 0; i<orgArr.length; i++) {
				if(el != orgArr[i]) {
					newArr[i] = orgArr[i];
				}
			}
		}
		return newArr;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		GridPane selectSeatsWrap = new GridPane();
		selectSeatsWrap.setVgap(10);
		selectSeatsWrap.setHgap(10);
		selectSeatsWrap.setLayoutX(176);
		selectSeatsWrap.setLayoutY(126);
		selectSeatsWrap.setPadding(new Insets(10, 0, 100, 0));
//		selectSeatsWrap.setPrefSize(900, 1800);
		for (int i = 0; i<200; i++) {
			String str = this.getSeatCode(i);
			Button btn = new Button();
			btn.setText(str);
			if(i<10 || i>=190) {
				btn.getStyleClass().add("booked-seats");
			}else {
				btn.getStyleClass().add("available-seats");
				btn.setOnAction(event -> handleSelection(event));;
			}
			selectSeatsWrap.add(btn, i%10, i/10);
		}
		seatsPane.getChildren().add(selectSeatsWrap);
	}
	
	public void handleSelection(ActionEvent event) {
		Button btn = ((Button)event.getSource());
//		System.out.println(btn.getStyleClass());
		boolean alreadySelected = Arrays.stream(selectedSeats).anyMatch(e -> e==btn.getText());
			if(alreadySelected) {
				selectedSeats = Arrays.stream(selectedSeats).filter(el -> el!=btn.getText()).toArray(String[]::new);
				selectedSeats = Arrays.stream(selectedSeats).filter(el -> el!=null).toArray(String[]::new);
				btn.getStyleClass().remove("selected-seats");
			}
			else {
				selectedSeats = Arrays.copyOf(selectedSeats, selectedSeats.length+1).clone();
				selectedSeats[selectedSeats.length - 1] = btn.getText();
				btn.getStyleClass().add("selected-seats");
			}
//		System.out.println(btn.getStyleClass() + " "+ selectedSeats.toString());
	}

}
