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


    public String toString() {
        String string = "Message type" + messageType + "[ ";
        for (String eachMessage : biglist) {
            string += " \"" + eachMessage + "\"";
        }
        string += " ] (FROM: " + fromName;
        string += " TO: " + toName + ")";
        return string;
    }
}
