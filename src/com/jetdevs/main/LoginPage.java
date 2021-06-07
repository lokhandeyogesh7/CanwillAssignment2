package com.jetdevs.main;
import org.json.JSONObject;

import com.jetdevs.api.getDataFromServer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginPage {

	Stage stage;
	BorderPane root;
	TextField usr, pwd;
	VBox loginVBox;
	HBox headerHbox, centerHBox, footerHBox;
	Label headerLabel, chooseTheme, loginLabel, footerLabel;
	Button lightTheme, darkTheme, login;

	public LoginPage(Stage stage) {
		this.stage = stage;
		initialize();
	}

	public void initialize() {
		createUI();
		addCSS("Light");
	}

	private void createUI() {
		root = new BorderPane();

		headerHbox = new HBox();
		headerHbox.setPrefHeight(100);
		headerHbox.setMaxHeight(100);
		headerHbox.setSpacing(10);

		ImageView logoImage = new ImageView(new Image(getClass().getResourceAsStream("/images/javafxLogo.png")));
		logoImage.setFitHeight(100);
		logoImage.setFitWidth(100);
		logoImage.setPreserveRatio(false);

		headerLabel = new Label("JavaFX Test Application");
		headerLabel.setPrefHeight(100);
		headerLabel.setMinHeight(100);
		headerLabel.setMaxHeight(100);
		headerLabel.setAlignment(Pos.CENTER_LEFT);
		headerLabel.setTextAlignment(TextAlignment.CENTER);

		HBox buttonHBox = new HBox();
		buttonHBox.setAlignment(Pos.CENTER_RIGHT);
		buttonHBox.setSpacing(20);
		buttonHBox.setPrefWidth(900);

		chooseTheme = new Label("Theme :");

		lightTheme = new Button("Light");
		lightTheme.setPrefHeight(30);
		lightTheme.setMinHeight(30);
		lightTheme.setPrefWidth(70);
		lightTheme.setMinWidth(70);
		lightTheme.setAlignment(Pos.CENTER);
		lightTheme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				addCSS("Light");
			}
		});

		darkTheme = new Button("Dark");
		darkTheme.setPrefHeight(30);
		darkTheme.setMinHeight(30);
		darkTheme.setPrefWidth(70);
		darkTheme.setMinWidth(70);
		darkTheme.setAlignment(Pos.CENTER);
		darkTheme.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				addCSS("Dark");
			}
		});

		buttonHBox.getChildren().addAll(chooseTheme, lightTheme, darkTheme);

		headerHbox.getChildren().addAll(logoImage, headerLabel, buttonHBox);

		centerHBox = new HBox();
		centerHBox.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(centerHBox, Pos.CENTER);
		centerHBox.setPrefHeight(400);

		loginVBox = new VBox();
		loginVBox.setPrefHeight(230);
		loginVBox.setMaxHeight(230);
		loginVBox.setMinHeight(230);
		loginVBox.setAlignment(Pos.TOP_CENTER);
		loginVBox.setSpacing(20);
		loginVBox.setPadding(new Insets(10, 30, 10, 30));

		loginLabel = new Label("User Login");
		loginLabel.setPrefHeight(30);
		loginLabel.setPrefWidth(300);
		loginLabel.setMaxWidth(300);
		loginLabel.setAlignment(Pos.CENTER);
		loginLabel.setTextAlignment(TextAlignment.CENTER);

		usr = new TextField();
		usr.setPromptText("Username");
		usr.setPrefHeight(30);
		usr.setPrefWidth(300);
		usr.setMaxWidth(300);

		pwd = new TextField();
		pwd.setPromptText("Password");
		pwd.setPrefHeight(30);
		pwd.setPrefWidth(300);
		pwd.setMaxWidth(300);

		login = new Button("Login");
		login.setPrefHeight(30);
		login.setPrefWidth(300);
		login.setMinWidth(300);
		login.setAlignment(Pos.CENTER);
		login.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				onLoginClicked();
			}
		});

		loginVBox.getChildren().addAll(loginLabel, usr, pwd, login);
		centerHBox.getChildren().add(loginVBox);

		footerHBox = new HBox();
		footerHBox.setPrefHeight(40);
		footerHBox.setMinHeight(40);
		footerHBox.setMaxHeight(40);
		footerHBox.setAlignment(Pos.CENTER_LEFT);

		footerHBox.setPadding(new Insets(10));
		footerLabel = new Label("Copyright @2021 JavaFX Test Application | Version 1.00.00");
		footerHBox.getChildren().add(footerLabel);

		root.setTop(headerHbox);
		root.setCenter(centerHBox);
		root.setBottom(footerHBox);
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	private void addCSS(String theme) {
		root.getStylesheets().clear();
		root.getStylesheets().add("/css/javaFXTest" + theme + ".css");
		headerHbox.getStyleClass().clear();
		headerHbox.getStyleClass().add("header-background");
		headerLabel.getStyleClass().clear();
		headerLabel.getStyleClass().add("text-primary-bold");
		chooseTheme.getStyleClass().clear();
		chooseTheme.getStyleClass().add("text-primary");
		lightTheme.getStyleClass().clear();
		lightTheme.getStyleClass().add("btn-light");
		darkTheme.getStyleClass().clear();
		darkTheme.getStyleClass().add("btn-dark");
		centerHBox.getStyleClass().clear();
		centerHBox.getStyleClass().add("center-background");
		loginVBox.getStyleClass().clear();
		loginVBox.getStyleClass().add("white-box");
		loginLabel.getStyleClass().clear();
		loginLabel.getStyleClass().add("text-primary-bg");
		login.getStyleClass().clear();
		login.getStyleClass().add("btn-primary");
		footerHBox.getStyleClass().clear();
		footerHBox.getStyleClass().add("footer-background");
		footerLabel.getStyleClass().clear();
		footerLabel.getStyleClass().add("text-white");
	}

	private void onLoginClicked() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert");

		String userName = usr.getText().trim();
		String password = pwd.getText();
		if (userName.isEmpty()) {
			alert.setContentText("Username is Empty");
			alert.showAndWait();
			usr.requestFocus();
			return;
		}

		if (password.isEmpty()) {
			alert.setContentText("Password is Empty");
			pwd.requestFocus();
			alert.showAndWait();
			return;
		}
		try {
			JSONObject obj = new JSONObject();
			obj.put("username", userName);
			obj.put("password", password);
			JSONObject response = new getDataFromServer().validateUser(obj);
			if (response != null) {
				if (response.has("errorMessage") && response.getString("errorMessage").equals("Sukses.")) {
					alert.setContentText("Login Success");
					alert.setAlertType(AlertType.INFORMATION);
				} else {
					alert.setContentText("Login Failed");
					alert.setAlertType(AlertType.INFORMATION);
				}
				alert.showAndWait();
			} else {
				alert.setContentText("Some error occurred");
				alert.setAlertType(AlertType.ERROR);
				alert.showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
