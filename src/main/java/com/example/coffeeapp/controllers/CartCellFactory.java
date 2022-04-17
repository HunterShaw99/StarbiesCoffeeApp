package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.models.CoffeeModel;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CartCellFactory implements Callback<ListView<CoffeeModel>, ListCell<CoffeeModel>> {

    @Override
    public ListCell<CoffeeModel> call(ListView<CoffeeModel> param) {
        return new CartCell();
    }

}
