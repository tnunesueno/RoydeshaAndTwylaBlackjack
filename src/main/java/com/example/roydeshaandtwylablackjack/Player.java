package com.example.roydeshaandtwylablackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Player {
    Boolean playerHit;
    int currentHandSum;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlayerHit() {
        return playerHit;
    }

    public void setPlayerHit(Boolean playerHit) {
        this.playerHit = playerHit;
    }

    public int getCurrentHandSum() {
        return currentHandSum;
    }

    public Player(String name) {
        this.name = name;
    }

    public void setCurrentHandSum(int currentHandSum) {
        this.currentHandSum = currentHandSum;
    }

    public void chooseHit () {
        if (playerHit = true) {
            //code that allows players to be given a card from the deck
        } else {
            //currentHandSum stays the same
        }

    }

    public void chooseStand () {

    }

 public void addCardToHand(Card card){
        this.setCurrentHandSum(currentHandSum+card.getValue());
 }

}
