package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.tasks.FavAddTask;
import com.example.coffeeapp.utility.ImageUrl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Console;
import java.io.IOException;
import java.util.UUID;

public class CoffeeCell extends ListCell<CoffeeModel> {

    @FXML
    private AnchorPane base;


    @FXML
    private Label beverageName, beveragePrice, flavorLabel, milkLabel, sizeLabel;

    @FXML
    private ImageView coffeeImage;

    @FXML
    private Button favBtn;

    @FXML
    private ImageView favPic;

    private boolean rb;

    private UUID itemID;

    public CoffeeCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(CartCell.class.getResource("CoffeeCell.fxml"));
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
            coffeeImage.setImage(new Image(beverage.getImage()));
            setGraphic(base);
            if (CoffeeManager.getInstance().getBeverageFavs(itemID) != null){
                favPic.setImage(new Image(ImageUrl.HEART));
                rb = false;

            }else{
                favPic.setImage(new Image(ImageUrl.EMPTY_HEART));
                rb = true;
            }
        }
    }

    @FXML
    void favEvent(MouseEvent event) {
        if (rb){

            CoffeeManager.getInstance().addBeverageFav(CoffeeManager.getInstance().getBeverageRecents(itemID));
            favPic.setImage(new Image(ImageUrl.HEART));
            rb = false;
        }else{
            favPic.setImage(new Image(ImageUrl.EMPTY_HEART));
            CoffeeManager.getInstance().removeBeverageFavs(CoffeeManager.getInstance().getBeverageFavs(itemID));
            rb = true;
        }

    }


}
