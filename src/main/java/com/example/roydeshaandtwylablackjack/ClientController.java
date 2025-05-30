package com.example.roydeshaandtwylablackjack;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController implements MessageController {
    public TextField ipText;
    public TextField portText;
    public Button connectButton;
    public TextField messageText;
    public Button sendButton;
    public ListView<MessageModel> messageList;

    ShoebQueue messagesIn;
    Socket clientSocket;
    ObjectOutputStream objectOut;
    boolean connectedToServer;

    public void initialize() {
        connectedToServer = false;
        messagesIn = new ShoebQueue();
    }

    public void connect() throws Exception {
        if (!connectedToServer) {
            String ipAddress = ipText.getText();
            int portNumber = Integer.parseInt(portText.getText());
            clientSocket = new Socket(ipAddress, portNumber);
            objectOut = new ObjectOutputStream(clientSocket.getOutputStream());
            ReaderThread read1 = new ReaderThread(clientSocket, messagesIn);
            Thread reader = new Thread(read1);
            WriterThread write1 = new WriterThread(null, null, messagesIn, this);
            Thread writer = new Thread(write1);
            reader.start();
            writer.start();
            connectedToServer = true;
            connectButton.setText("Disconnect");
            sendButton.setDisable(false);
        } else {
            connectedToServer = false;
            connectButton.setText("Connect");
            sendButton.setDisable(true);
        }
    }

    public void send() {
        try {
            MessageModel message1 = new MessageModel(2, messageText.getText(), "Client", "ALL");
            objectOut.writeObject(message1);
        } catch (Exception ex) {
            System.out.println("CLIENT failed to write to socket " + clientSocket);
        }
    }

    public void receiveMessage(MessageModel message) {
        messageList.getItems().addFirst(message);
    }
}