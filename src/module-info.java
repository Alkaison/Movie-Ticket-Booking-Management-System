module MovieTicketBookingSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;

	opens application to javafx.graphics, javafx.fxml;
	opens application.controllers to javafx.fxml;
}
