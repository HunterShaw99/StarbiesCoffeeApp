package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.models.CoffeeModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.UUID;

public class CartCell extends ListCell<CoffeeModel> {

    @FXML
    private AnchorPane base;

    @FXML
    private Label beverageName;

    @FXML
    private ImageView coffeeImage;

    private UUID beverageID;

    public CartCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(CartCell.class.getResource("cart-cell-view.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(CoffeeModel beverage, boolean empty) {
        super.updateItem(beverage, empty);

        if (empty || beverage == null) {
            setText(null);
            setGraphic(null);
        } else {
            beverageID = beverage.getItemID();
            beverageName.setText(beverage.getName());
            //milkLabel.setText(beverage.getMilk().getDairy());
            //flavorLabel.setText("Flavors: "+beverage.getFlavors());
            //priceLabel.setText("$"+beverage.getPrice().toString());
            //sizeLabel.setText(beverage.getSize().getVal());
            coffeeImage.setImage(new Image(beverage.getImage()));
            setGraphic(base);
        }
    }


}
