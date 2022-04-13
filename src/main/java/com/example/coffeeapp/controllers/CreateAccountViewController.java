package com.example.coffeeapp.controllers;

import com.example.coffeeapp.tasks.ViewChangeTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CreateAccountViewController {

    @FXML
    private Pane AccountPane;

    @FXML
    private Label accountLabel;

    @FXML
    private Button createBtn;

    @FXML
    private TextField emailTxtFld;

    @FXML
    private TextField firstNameTxtFld;

    @FXML
    private TextField lastNameTxtFld;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField passwordTxtFld;

    @FXML
    void accountEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(4));
    }

    @FXML
    void loginEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(4));
    }

}

