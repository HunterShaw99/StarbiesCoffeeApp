package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.tasks.CartAddTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomizationController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<CoffeeModel> customizeListView;

    @FXML
    private Button finishButton;

    @FXML
    private HBox headerBox;

    @FXML
    private Label totalPriceLabel;

    public void initialize() {
        customizeListView.setItems(CartManager.GetInstance().GetCurrentItemList());
        customizeListView.setCellFactory(new CustomizeCellFactory());
    }

    @FXML
    void AddToCart(MouseEvent event) throws IOException {
        Platform.runLater(new CartAddTask());

    }

    @FXML
    void ToMenuEvent(MouseEvent event) throws IOException {

    }
}
