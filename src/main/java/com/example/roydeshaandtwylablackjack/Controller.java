package com.example.roydeshaandtwylablackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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


    public void initialize() throws IOException {
        Card firstCard = new Card("2_of_clubs.png");

    }
}
