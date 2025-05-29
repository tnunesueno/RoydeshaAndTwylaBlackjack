
package com.example.roydeshaandtwylablackjack;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Card {
    public Image cardImage;
    public int value;
    public String suit;
    public String face;
    public Player playerBelong;
    public boolean visible;
    public static ArrayList<Card> cardList = new ArrayList<>();
    //public ZipFile zipFile;

    public Card (String cardName) throws IOException {

        int underScore1 = cardName.indexOf("_");

       if (underScore1==1){
           int cardNum = parseInt(cardName.substring(0,underScore1));
           this.setValue(cardNum);
           this.setFace(null);
       } else {
           String cardFace = cardName.substring(0,underScore1);
           this.setValue(10);
           this.setFace(cardFace);
       }

       int period = cardName.indexOf(".");
       String cardSuit = cardName.substring(underScore1+4, period);
       if(cardSuit.contains("2")){
           cardSuit.replaceAll("2", "");
       }
       this.setSuit(cardSuit);

        FileInputStream stream = new FileInputStream("src/main/java/com/example/roydeshaandtwylablackjack/"+ cardName);
        Image image = new Image(stream);
        this.setCardImage(image);

        cardList.add(this);
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public Player getPlayerBelong() {
        return playerBelong;
    }

    public void setPlayerBelong(Player playerBelong) {
        this.playerBelong = playerBelong;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
