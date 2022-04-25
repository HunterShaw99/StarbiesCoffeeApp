package com.example.coffeeapp;

// SimpleNetworkExample1Client.java
// Simple client program to connect to SimpleNetworkExample1Server and receive a message\

import java.net.*;
import java.io.*;

public class ClientNetwork{
    // Use same port as server
    static final int port = 5001;
    public static void main( String [] args) {
        ObjectInputStream oistream;
        try {
            // Find IP address of host machine
            // For this simple test we are not actually using a network
            // so "localhost" specifies same machine
            InetAddress addr =
                    InetAddress.getByName("localhost");
            System.out.println("Server address = " + addr);
            // Set up socket on client side that connects to server
            Socket socket = new Socket(addr, port);
            System.out.println("Connected to socket: " + socket);

            // Set up stream to receive message from the server
            // This mirrors the oostream statement on the server
            oistream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Receiving message....");
            String str = (String) oistream.readObject();
            // Input above corresponds to oostream.writeObject in the
            // SimpleNetworkExample1Server program
            System.out.println(str);
            // Close socket when finished
            socket.close();
        }
        catch( Exception e) {
            e.printStackTrace();
        }
    }
}
