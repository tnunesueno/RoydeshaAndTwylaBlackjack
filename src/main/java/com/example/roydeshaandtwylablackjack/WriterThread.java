package com.example.roydeshaandtwylablackjack;

import javafx.application.Platform;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class WriterThread implements Runnable {
    ShoebQueue myData;
    boolean isServer;
    ArrayList<Socket> sockets;
    ArrayList<ObjectOutputStream> objectOuts;
    MessageController myController;

    public WriterThread(ArrayList<Socket> sockets, ArrayList<ObjectOutputStream> outs, ShoebQueue myData, MessageController myController) throws Exception {
        this.sockets = sockets;
        this.objectOuts = outs;
        this.myData = myData;
        this.isServer = (sockets != null);
        this.myController = myController;
    }

    public void run() {
        while (!Thread.interrupted()) {
            // GET from myData (to communicate from ReaderThread)
            MessageModel message = myData.get();
            while (message == null) {
                message = myData.get();
            }
            // PROCESS the message:
            if (isServer) {
                // Servers WRITE the message to ALL Clients
                System.out.println("WRITER THREAD SERVER: " + message);
                for (ObjectOutputStream objectOut: objectOuts) {
                    try {
                        message.setMessage("LOL SOMEONE wrote: " + message.getMessage());
                        objectOut.writeObject(message);
                    } catch (Exception ex) {
                        System.out.println("WRITER THREAD SERVER failed to write: " + ex);
                    }
                }
            }

            // BOTH Server and Client display their message in their View
            MessageModel finalMessage = message;
            Platform.runLater(new Runnable() {
                public void run() {
                    myController.receiveMessage(finalMessage);
                }
            });
        }

        try {
            for (ObjectOutputStream objectOut: objectOuts) {
                objectOut.close();
            }
            for (Socket eachSocket: sockets) {
                eachSocket.close();
            }
        } catch (Exception ex) {
            System.out.println("WRITER THREAD closing failed: " + ex);
        }
    }
}
