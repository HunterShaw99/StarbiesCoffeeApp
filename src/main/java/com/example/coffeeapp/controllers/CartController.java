package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.observer.Observer;
import com.example.coffeeapp.tasks.ViewChangeTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


import java.math.BigDecimal;

public class CartController implements Observer {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label menuLabel, totalLabel, totalValueLabel;

    @FXML
    private ListView<CoffeeModel> menuListView;

    @FXML
    private Pane menuPane;

    private byte init = 0;

    public void initialize() {

        if (init == 0) {
            menuListView.setItems(CoffeeManager.getInstance().getItemsCart());
            menuListView.setCellFactory(new CartCellFactory());
            totalValueLabel.setText("$"+BigDecimal.ZERO);
            CoffeeManager.getInstance().registerObserver(this);
            init++;
        }
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
    void MenuEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(0));
    }

    @FXML
    void RecentsEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(2));
    }



    @Override
    public void update(BigDecimal total) {
        //Will update the cart total here when an item is added/removed in CartManager class
        totalValueLabel.setText("$"+total);
    }
}
