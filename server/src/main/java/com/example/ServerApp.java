package com.example.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {

        String[] test = new String[1];
        test[0]= "server";

        TwoWayCommunicationServer S = new TwoWayCommunicationServer(test);

    }
}
