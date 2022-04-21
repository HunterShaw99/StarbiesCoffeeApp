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


public class FavController implements Observer{

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label favLabel;

    @FXML
    private ListView<CoffeeModel> favListView;

    @FXML
    private Pane favPane;


    private byte init = 0;

    public void initialize() {

        if (init == 0){
            favListView.setItems(CoffeeManager.getInstance().getItemsFav());
            favListView.setCellFactory(new CoffeeCellFactory());
            //FavManager.GetInstance().registerObserver(this);
            init++;

        }

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


    @Override
    public void update(BigDecimal total) {

    }
}
