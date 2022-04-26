package com.example.user;

// SimpleNetworkExample1Server.java
// Example of a simple server implemented in Java.  This server
// sends a message to a client that accesses it

import com.example.data.models.CoffeeModel;

import java.io.*;
import java.net.*;


public class ServerNetwork {

    public static final int PORT = 5001;
    public static void main(String [] args) throws IOException {

        ObjectOutputStream oostream;
        ObjectInputStream oistream;
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started: " + s);
        int count = 0;  // how many times server is used


        try {
            while(true) {
                // Server waits for a connection.
                // When a connection occurs, a socket is assigned
                Socket socket = s.accept();
                try {

                    System.out.println("Connection " + (++count) + " accepted "+
                            socket);
                    // In order to send a message to a client, the server needs an
                    // OutputStream from the socket. It then uses this to set up
                    // stream for communication.  In the client program, there is
                    // a corresponding input stream
                    // If we wanted two-way communication we would also set up an
                    // input stream here and an output stream in the client.
                    // Use ObjectOutputStream for convenience
                    oostream = new ObjectOutputStream(socket.getOutputStream());

                    oostream.flush();  // to send header info to client
                    // Send messages to console and to client
                    System.out.println("Sending message to client " + count);
                    oostream.writeObject("Hello, client " + count);

                    oistream = new ObjectInputStream(socket.getInputStream());
                    CoffeeModel x =  (CoffeeModel) oistream.readObject();
                    //CoffeeModel x = new CoffeeModel();
                    System.out.println("Reading from client: " + x);

                }
                catch( Exception e) {
                    e.printStackTrace();
                }
//                finally {
//
//                    System.out.println("Closing connection ....");
//                    socket.close();
//                }
            }  // while loop to establish connections
        } // outermost try block
        catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Server shutting down");
            s.close();
        }
    }
}
