package com.example.roydeshaandtwylablackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.example.roydeshaandtwylablackjack.Card.imageToCard;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("boardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("BLACKJACK!");
        stage.setScene(scene);
        stage.show();

      FileInputStream stream = new FileInputStream("src/main/java/com/example/roydeshaandtwylablackjack/2_of_clubs.png");
        // logic here to parse name
        imageToCard(stream, "2 of clubs");
    }

    public static void main(String[] args) {
        launch();
    }
}