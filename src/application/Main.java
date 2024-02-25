package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// creating root node and scene
			Group root = new Group();
			Scene scene1 = new Scene(root, Color.DARKGREY);

			primaryStage.setTitle("Movie Ticket Booking Management System");
			primaryStage.setWidth(1200);
			primaryStage.setHeight(700);

			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
