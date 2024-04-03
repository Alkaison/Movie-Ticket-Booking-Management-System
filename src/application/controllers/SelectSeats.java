package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
			newArr = orgArr.clone();
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
//		selectSeatsWrap.setPrefSize(900, 1800);
		for (int i = 0; i<200; i++) {
			String str = this.getSeatCode(i);
			Button btn = new Button();
			btn.setText(str);
			if(i<10 || i>=190) {
				btn.getStyleClass().add("selected-seats");
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
		for (int i = 0; i<selectedSeats.length; i++) {
			String el = selectedSeats[i];
			if(btn.getText() == el) {
				selectedSeats = this.getUpdatedSelection(selectedSeats, 0, btn.getText()).clone();
				btn.getStyleClass().remove("current-seats");
				break;
			}
			else {
				selectedSeats = this.getUpdatedSelection(selectedSeats, 1, btn.getText()).clone();
				btn.getStyleClass().add("current-seats");
				break;
			}
		}
	}

}
