package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.NetworkManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class LoginView {

    @FXML
    private Pane LoginPane;

    @FXML
    private Button loginBtn;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField passTxtFld;

    @FXML
    private TextField usernameTxtFld;

    static final int port = 5001;

    @FXML
    void loginEvent(MouseEvent event) throws IOException, ClassNotFoundException {
        int id = usernameTxtFld.getText().hashCode();
        System.out.println(id);
        InetAddress addr =
                InetAddress.getByName("localhost");
        System.out.println("Server address = " + addr);
        // Set up socket on client side that connects to server
        Socket socket = new Socket(addr, port);
        System.out.println("Connected to socket: " + socket);
        NetworkManager.getInstance().setClient(socket);
        ControllerHandler.GetInstance().Transition(0);
    }
    @FXML
    void accountEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(5);
    }

}
