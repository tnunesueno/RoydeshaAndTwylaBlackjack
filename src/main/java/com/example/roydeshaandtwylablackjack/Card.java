
package com.example.roydeshaandtwylablackjack;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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

    public static Array zipToCardArray(String zipFilePath) throws IOException {
        File file = new File(zipFilePath);
        ArrayList cardArray = new ArrayList<Card>();
        ZipFile zipfile = new ZipFile(file);
        Enumeration<?extends ZipEntry> entries= zipfile.entries();

        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            System.out.println("Entry name: "+entry.getName());
            Files.copy(zipfile.getInputStream(entry), Paths.get("destination/path/" + entry.getName()));
            Card card = new Card();
        }

        return null;
    }
}
