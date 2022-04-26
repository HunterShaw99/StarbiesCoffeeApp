package com.example.coffeeapp;

import com.example.coffeeapp.controllers.ControllerHandler;
import com.example.coffeeapp.data.NetworkManager;
import com.example.coffeeapp.tasks.ViewChangeTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class CoffeeApp extends Application {

    static final int port = 5001;
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        InetAddress addr =
                InetAddress.getByName("localhost");
        System.out.println("Server address = " + addr);
        // Set up socket on client side that connects to server
        Socket socket = new Socket(addr, port);
        System.out.println("Connected to socket: " + socket);
        NetworkManager.getInstance().setClient(socket);
        stage.setTitle("Stardoes Coffee");
        ControllerHandler.GetInstance().SetStage(stage);
        Platform.runLater(new ViewChangeTask(4));
    }

    public static void main(String[] args) {
        launch();
    }
}
