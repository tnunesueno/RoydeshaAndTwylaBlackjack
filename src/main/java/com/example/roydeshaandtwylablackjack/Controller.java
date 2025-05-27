package com.example.roydeshaandtwylablackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {
    @FXML
    Button hitOne;
    @FXML
    Button standOne;
    @FXML
    Button hitTwo;
    @FXML
    Button standTwo;
    @FXML
    ImageView deckOfCards;




    public void initialize() throws IOException {

        Card firstCard = new Card("2_of_clubs.png");

        System.out.println("suit: " + firstCard.getSuit());

        // + firstCard.getFace() + firstCard.getValue()

    }
}
