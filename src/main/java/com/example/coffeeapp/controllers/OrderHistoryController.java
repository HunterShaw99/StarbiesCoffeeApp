package com.example.coffeeapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class OrderHistoryController {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label historyLabel;

    @FXML
    private ListView<?> historyListView;

    @FXML
    private Pane historyPane;

    @FXML
    void MenuEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(0);
    }

    @FXML
    void CartEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(3);
    }

    @FXML
    void FavEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(1);
    }

    @FXML
    void RecentsEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(2);
    }

}
