package com.example.coffeeapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

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

    @FXML
    void loginEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(0);
    }

}
