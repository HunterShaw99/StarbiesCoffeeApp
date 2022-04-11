package com.example.coffeeapp.controllers;

import com.example.coffeeapp.tasks.ViewChangeTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class MenuController {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Button logoutBtn;

    @FXML
    private ImageView logoutImg;


    @FXML
    private Label menuLabel;

    @FXML
    private ListView<?> menuListView;

    @FXML
    private Pane menuPane;

    public void initialize() {

    }

    @FXML
    void MenuEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(0));
    }

    @FXML
    void CartEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(3));
    }

    @FXML
    void FavEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(1));
    }

    @FXML
    void RecentsEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(2));
    }


    @FXML
    void LogoutEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(4));
    }


}
