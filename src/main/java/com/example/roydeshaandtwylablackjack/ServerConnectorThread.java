package com.example.roydeshaandtwylablackjack;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnectorThread implements Runnable {
    ServerSocket serverSocket;
    ArrayList<Socket> allSockets;
    ArrayList<ObjectOutputStream> allObjectOuts;
    ShoebQueue onlyOneDataStructure;
    WriterThread onlyOneWriterThread;

    public ServerConnectorThread(int port, MessageController controller) throws Exception {
        this.onlyOneDataStructure = new ShoebQueue();
        this.allSockets = new ArrayList<Socket>();
        this.allObjectOuts = new ArrayList<ObjectOutputStream>();
        this.onlyOneWriterThread = new WriterThread(allSockets, allObjectOuts, onlyOneDataStructure, controller);
        Thread writer = new Thread(onlyOneWriterThread);
        writer.start();

        // Server now starts listening for new clients
        this.serverSocket = new ServerSocket(port);
    }

    public void run()  {
        Socket client;
        int clientNum = 1;
        while (!Thread.interrupted()) {
            try {
                System.out.println("I'm still here " + clientNum++);
                client = serverSocket.accept(); // blocking api
                allSockets.add(client);
                allObjectOuts.add(new ObjectOutputStream(client.getOutputStream()));
                ReaderThread extraReaderThreadPerClient = new ReaderThread(client, onlyOneDataStructure);
                Thread extraReader = new Thread(extraReaderThreadPerClient);
                extraReader.start();
            } catch (Exception ex) {
                System.out.println("ServerConnectorThread failed: " + ex);
            }
        }

        try {
            serverSocket.close();
        } catch (Exception ex) {
            System.out.println("ServerConnectorThread closing failed: " + ex);
        }
    }
}
