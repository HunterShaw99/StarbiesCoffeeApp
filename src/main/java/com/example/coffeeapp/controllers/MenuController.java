package com.example.coffeeapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label menuLabel;

    @FXML
    private ListView<?> menuListView;

    @FXML
    private Pane menuPane;

    public void initialize() {

    }

    @FXML
    void CartEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(3);
    }


}
