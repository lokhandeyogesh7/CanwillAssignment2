package com.jetdevs.main;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ApplicationLauncher extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			primaryStage.setTitle("JavaFX Test");
			primaryStage.setX(screen.getMinX());
			primaryStage.setY(screen.getMinY());
			primaryStage.setHeight(screen.getHeight());
			primaryStage.setWidth(screen.getWidth());
			new LoginPage(primaryStage);
			primaryStage.show();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
