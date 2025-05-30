package com.example.roydeshaandtwylablackjack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReaderThread implements Runnable{
    Socket socket;
    ShoebQueue myData;
    ObjectInputStream inObject;

    public ReaderThread(Socket socket, ShoebQueue myData) throws Exception {
        this.socket = socket;
        this.myData = myData;
        this.inObject = new ObjectInputStream(socket.getInputStream());
    }

    public void run() {
        while (!Thread.interrupted()) {
            // READ from Socket
            MessageModel message = null;
            try {
                message = (MessageModel)inObject.readObject();
            } catch (IOException e) {
                // its ok to get IOException when there is no object to read in from ObjectInputStream
                //System.out.println("ReaderThread ERROR: " + e);
            } catch (ClassNotFoundException ex) {
                System.out.println("ReaderThread readObject ERROR: " + ex);
            } catch (Exception ex) {
                System.out.println("ReaderThread readObject ERROR: " + ex);
            }

            // IGNORE null messages by continuing to next while loop iteration
            if (message == null) {
                continue;
            }

            // PUT to myData (to communicate with WriterThread)
            boolean success = myData.put(message);
            while (!success) {
                success = myData.put(message);
            }
            System.out.println("READER THREAD READ: " + message);
        }

        try {
            inObject.close();
            socket.close();
        } catch (Exception ex) {
            System.out.println("ReaderThread closing failed: " + ex);
        }

    }
}
