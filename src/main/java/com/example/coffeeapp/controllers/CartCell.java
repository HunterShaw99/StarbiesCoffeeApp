package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.tasks.DupBeverageTask;
import com.example.coffeeapp.tasks.RemoveBeverageTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.UUID;

public class CartCell extends ListCell<CoffeeModel> {

    @FXML
    private AnchorPane base;

    @FXML
    private Label beverageName, beveragePrice,milkLabel, sizeLabel, flavorLabel;

    @FXML
    private Button addButton, removeButton, editButton;

    @FXML
    private ImageView coffeeImage;

    private UUID itemID;

    public CartCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(CartCell.class.getResource("CartCell.fxml"));
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
            itemID = beverage.getItemID();
            beverageName.setText(beverage.getName());
            milkLabel.setText(beverage.getMilk().getDairy());
            flavorLabel.setText(beverage.getFlavors().toString().toLowerCase());
            beveragePrice.setText("$"+beverage.getPrice());
            sizeLabel.setText(beverage.getSize().getVal());
            //coffeeImage.setImage(new Image(beverage.getImage()));
            setGraphic(base);
        }
    }

    @FXML
    void DuplicateBeverageEvent(MouseEvent event) {
        UUID x = itemID;
        Platform.runLater(new DupBeverageTask(x));
    }

    @FXML
    void RemoveBeverageEvent(MouseEvent event) {
        Platform.runLater(new RemoveBeverageTask(itemID));
    }

    @FXML
    void EditBeverageEvent(MouseEvent event) {
        System.out.println(CartManager.GetInstance().GetBeverage(itemID));
    }


}
