package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.models.CoffeeModel;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CoffeeCellFactory implements Callback<ListView<CoffeeModel>, ListCell<CoffeeModel>> {

    @Override
    public ListCell<CoffeeModel> call(ListView<CoffeeModel> coffeeModelListView) {
        return new CoffeeCell();
    }

}
