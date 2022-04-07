package com.example.coffeeapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CoffeeCell {

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

}
