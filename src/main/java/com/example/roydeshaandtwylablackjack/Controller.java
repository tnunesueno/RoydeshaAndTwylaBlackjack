package com.example.roydeshaandtwylablackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import com.example.roydeshaandtwylablackjack.*;

import static java.lang.Math.random;

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
        File[] files = new File("./src/main/java/com/example/roydeshaandtwylablackjack/cards").listFiles();
        System.out.println(files[0]);

        for (File fileName: files){


            if (fileName.isFile()){
                String stuffToReplace = new String("src/main/java/com/example/roydeshaandtwylablackjack/cards");
                System.out.println(stuffToReplace);
                String fileNameString = fileName.getName().replaceAll(stuffToReplace, "");
                System.out.println(fileNameString);
                Card newCard = new Card(fileNameString);
            }
        }

        Random random = new Random();
        int randomNumber = random.nextInt(52);
        Card selectedCard = Card.cardList.get(randomNumber);
        System.out.println(selectedCard.getSuit() +" of " + selectedCard.getValue());
        deckOfCards.setImage(selectedCard.getCardImage());
    }
}
