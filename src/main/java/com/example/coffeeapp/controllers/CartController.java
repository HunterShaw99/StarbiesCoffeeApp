package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class CartController {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label menuLabel;

    @FXML
    private ListView<CoffeeModel> menuListView;

    @FXML
    private Pane menuPane;

    private byte init = 0;

    public void initialize() {
        if (init == 0) {
            menuListView.setItems(CartManager.GetInstance().GetCartItems());
            menuListView.setCellFactory(new CartCellFactory());
            init++;
        }
    }

    @FXML
    void AddBevCart(MouseEvent event) {
        CoffeeModel m = new CoffeeModel();
        m.setName("Cold Brew a");
        CartManager.GetInstance().AddBeverage(m);
        System.out.println(m);
    }


}
