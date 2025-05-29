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
    @FXML
    ImageView player1Card1;
    @FXML
    ImageView player1Card2;
    @FXML
    ImageView player2Card1;
    @FXML
    ImageView player2Card2;
    @FXML
    ImageView dealerCard1;
    @FXML
    ImageView dealerCard2;

    public void initialize() throws IOException {
        // adding players here for now, i'm pretty sure we want to do it in a smarter networked way later - Twyla
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player dealer = new Player("Dealer");

        File[] files = new File("./src/main/java/com/example/roydeshaandtwylablackjack/cards").listFiles();
        System.out.println(files[0]);

        for (File fileName: files){
            if (fileName.isFile()){
                String stuffToReplace = new String("src/main/java/com/example/roydeshaandtwylablackjack/cards");
                System.out.println(stuffToReplace);
                String fileNameString = fileName.getName().replaceAll(stuffToReplace, "");
                System.out.println(fileNameString);
                Card newCard = new Card(fileNameString);
                System.out.println("NUMBER OF CARDS IN DECK: "+ Card.cardList.size());
            }
        }

        // this should prob be a for loop if twyla gets less lazy
        deal(player1Card1, player1);
        deal(player1Card2, player1);
        deal(player2Card1, player2);
        deal(player2Card2, player2);
        deal(dealerCard1, dealer);
        deal(dealerCard2, dealer);
    }

    public void deal(ImageView imageview, Player player){
        Random random = new Random();
        int cardsInDeck = Card.cardList.size();
        if(cardsInDeck>0) {
            int randomNumber = random.nextInt(cardsInDeck);
            Card selectedCard = Card.cardList.get(randomNumber);
            System.out.println("selected card: " + selectedCard.getValue() + " of " + selectedCard.getSuit());
            imageview.setImage(selectedCard.getCardImage()); // this puts it in the right spot
            Card.cardList.remove(selectedCard);

            player.addCardToHand(selectedCard);
            System.out.println(player.getName()+ " current hand value: " +player.getCurrentHandSum());
        } else {
            System.out.println("NO CARDS IN DECK");
        }
    }
}
