
package com.example.roydeshaandtwylablackjack;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Card {
    public Image cardImage;
    public int value;
    public String suit;
    public String face;
    public Player playerBelong;
    public boolean visible;
    //public ZipFile zipFile;

    public Card(Image cardImage, int value, String suit, String face, Player playerBelong, boolean visible) {
        this.cardImage = cardImage;
        this.value = value;
        this.suit = suit;
        this.face = face;
        this.playerBelong = playerBelong;
        this.visible = visible;
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

    public static Card imageToCard(FileInputStream stream, String name) throws IOException {
      //  String fullName = stream.toString();
        Image image = new Image(stream);

        Card card = new Card(image, 0, null, null, null, true);
        System.out.println("card Image: "+ card.getCardImage() +" card suit: "+ card.getSuit()+ " card name: "+ card.getFace());
        return card;
    }
}
