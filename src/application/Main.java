package application;

import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// creating root node and scene
			Group root = new Group();
			Scene scene1 = new Scene(root, Color.rgb(19, 13, 14));

			// stage title
			primaryStage.setTitle("Movie Ticket Booking Management System");

			// set application icon
			URL iconPath = getClass().getResource("resources/icon.png");
			Image icon = new Image(iconPath.toString());
			primaryStage.getIcons().add(icon);

			// TEMP: add application logo at center
			ImageView imgView = new ImageView(icon);
			imgView.setFitWidth(250);
			imgView.setFitHeight(250);
			imgView.setPreserveRatio(true);
			imgView.setX(475);
			imgView.setY(200);

			// TEMP: add title text
			Text text = new Text();
			text.setText("Movie Ticket Booking Management System");
			text.setX(350);
			text.setY(175);
			text.setFont(Font.font("Verdana", 24));
			text.setFill(Color.BEIGE);

			// add the image and text into scene
			root.getChildren().add(imgView);
			root.getChildren().add(text);

			// minimum width and height for stage window
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(700);

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
