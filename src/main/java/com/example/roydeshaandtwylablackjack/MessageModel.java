package com.example.roydeshaandtwylablackjack;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageModel implements Serializable {
    int messageType;
    ArrayList<Card> biglist;
    Player player1;
    Player player2;
    Player player3;
    String fromName;
    String toName;
    Boolean isPlayer1;

    public MessageModel(int messageType, ArrayList<Card> biglist, Player player1, Player player2, Player player3, String fromName, String toName, Boolean isPlayer1) {
        this.messageType = messageType;
        this.biglist = biglist;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.fromName = fromName;
        this.toName = toName;
        this.isPlayer1 = isPlayer1;
    }

    public String toString() {
        String string = "Message type" + messageType + "[ ";
        for (Card eachMessage : biglist) {
            string += " \"" + eachMessage + "\"";
        }
        string += " ] (FROM: " + fromName;
        string += " TO: " + toName + ")";
        return string;
    }
}
