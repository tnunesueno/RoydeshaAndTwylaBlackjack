package com.example.roydeshaandtwylablackjack;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageModel implements Serializable {
    int messageType;
    ArrayList<String> theMessages;
    String fromName;
    String toName;

    public MessageModel(int messageType, String theMessage, String fromName, String toName) {
        this.messageType = messageType;
        this.theMessages = new ArrayList<String>();
        this.theMessages.add(theMessage);
        this.fromName = fromName;
        this.toName = toName;
    }

    public MessageModel(int messageType, ArrayList<String> messages, String fromName, String toName) {
        this.messageType = messageType;
        this.theMessages = messages;
        this.fromName = fromName;
        this.toName = toName;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public ArrayList<String> getMessages() {
        return theMessages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.theMessages = messages;
    }

    public String getMessage() {
        return theMessages.getFirst();
    }

    public void setMessage(String message) {
        this.theMessages.set(0, message);
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String toString() {
        String string = "Message type" + messageType + "[ ";
        for (String eachMessage : theMessages) {
            string += " \"" + eachMessage + "\"";
        }
        string += " ] (FROM: " + fromName;
        string += " TO: " + toName + ")";
        return string;
    }
}
