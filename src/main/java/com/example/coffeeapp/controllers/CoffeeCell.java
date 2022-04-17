package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.models.CoffeeModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CoffeeCell extends ListCell<CoffeeModel> {

    @FXML
    private AnchorPane base;

    @FXML
    private Label beverageName;

    @FXML
    private ImageView coffeeImage;

    @FXML
    private Label flavorLabel;

    @FXML
    private ImageView heartPic;

    @FXML
    private Label milkLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    private boolean heart = false;

    @FXML
    void heartClicked(MouseEvent event) {

        if (!heart){
            heartPic.setImage(new Image("@../images/redHeart.png"));
        } else if (heart){
            heartPic.setImage(new Image("@../images/openHeart.png"));
        }
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
            //itemID = beverage.getItemID();
            beverageName.setText(beverage.getName());
            milkLabel.setText(beverage.getMilk().getDairy());
            flavorLabel.setText(beverage.getFlavors().toString().toLowerCase());
            //beveragePrice.setText("$"+beverage.getPrice());
            sizeLabel.setText(beverage.getSize().getVal());
            coffeeImage.setImage(new Image(beverage.getImage()));
            setGraphic(base);
        }
    }

}
