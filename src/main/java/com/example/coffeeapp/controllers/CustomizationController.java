package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.tasks.CartAddTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


import java.io.IOException;

public class CustomizationController {

    @FXML
    private ListView<CoffeeModel> customizeListView;

    @FXML
    private Button finishButton;

    @FXML
    private HBox headerBox;


    public void initialize() {
        customizeListView.setItems(CoffeeManager.getInstance().getCurrentItemList());
        customizeListView.setCellFactory(new CustomizeCellFactory());
    }

    @FXML
    void AddToCart(MouseEvent event) throws IOException {
        Platform.runLater(new CartAddTask());
        ControllerHandler.GetInstance().Transition(3);

    }

    @FXML
    void ToMenuEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(0);
    }
}
