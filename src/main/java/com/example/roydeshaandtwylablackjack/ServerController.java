package com.example.roydeshaandtwylablackjack;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ServerController implements MessageController {
    public Label ipText;
    public TextField portText;
    public Button startButton;
    public ListView<MessageModel> messageList;

    public void start() throws Exception {
        int portNumber = Integer.parseInt(portText.getText());
        ServerConnectorThread connectorThread = new ServerConnectorThread(portNumber, this);
        Thread thread1 = new Thread(connectorThread);
        thread1.start();
    }

    public void receiveMessage(MessageModel message) {
        messageList.getItems().addFirst(message);
    }

}