package com.example.roydeshaandtwylablackjack;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello I'm the client ");
        Socket socket = new Socket("127.0.0.1", 25783);

        ShoebQueue myData = new ShoebQueue();
        ReaderThread read1 = new ReaderThread(socket, myData);
        Thread reader = new Thread(read1);
        WriterThread write1 = new WriterThread(null, null, myData, null);
        Thread writer = new Thread(write1);
        reader.start();
        writer.start();

        // ????????????? HOW DO WE WRITE 1 message ?????????
        //myData.put("Hi it's ME.");
        MessageModel message1 = new MessageModel(1, "Hi it's ME.", "Client", "ALL");
        myData.put(message1);
    }
}
