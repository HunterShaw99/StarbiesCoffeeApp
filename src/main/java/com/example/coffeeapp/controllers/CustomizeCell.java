package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.data.models.constants.CoffeePrice;
import com.example.coffeeapp.data.models.constants.Dairy;
import com.example.coffeeapp.data.models.constants.Flavor;
import com.example.coffeeapp.data.models.constants.Size;
import com.example.coffeeapp.tasks.EditDairyTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.NumberFormat;

public class CustomizeCell extends ListCell<CoffeeModel> {

    @FXML
    private RadioButton _2percentLabel, almondLabel, largeLabel,
            mediumLabel, noDairyLabel, nonFatLabel, smallLabel, soyLabel, wholeLabel;
    @FXML
    private CheckBox caramelCheckBox, mochaCheckBox, vanillaCheckBox,
            pumpkinCheckBox, hazelnutCheckBox, coconutCheckBox;
    @FXML
    private VBox base, flavorBox;
    @FXML
    private ImageView beverageImageView;
    @FXML
    private Label beverageNameLabel, dairyLabel, flavorLabel, largePriceLabel,
            mediumPriceLabel, sizeLabel, smallPriceLabel, diaryNoteLabel;
    @FXML
    private VBox dairyBox;
    @FXML
    private ToggleGroup dairyGroup, sizeGroup;
    @FXML
    private HBox headerHBox, sizeHBox;
    @FXML
    private Separator pageBreak;

    public void initialize() {
        setDefaultDiary();
        setDefaultSize();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        smallPriceLabel.setText(formatter.format(CoffeePrice.SMALL_COST));
        mediumPriceLabel.setText(formatter.format(CoffeePrice.MEDIUM_COST));
        largePriceLabel.setText(formatter.format(CoffeePrice.LARGE_COST));
        diaryNoteLabel.setText("Non-dairy options are available at additional cost of "+formatter.format(CoffeePrice.NON_DAIRY_COST));
        AddEventHandlerForCheckbox(caramelCheckBox);
        AddEventHandlerForCheckbox(mochaCheckBox);
        AddEventHandlerForCheckbox(vanillaCheckBox);
        AddEventHandlerForCheckbox(pumpkinCheckBox);
        AddEventHandlerForCheckbox(hazelnutCheckBox);
        AddEventHandlerForCheckbox(coconutCheckBox);
    }

    public CustomizeCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(CustomizeCell.class.getResource("CustomizeCell.fxml"));
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
            beverageNameLabel.setText(beverage.getName());
            beverageImageView.setImage(new Image(beverage.getImage()));
            setGraphic(base);
        }
    }

    private void setDefaultDiary() {
        noDairyLabel.setSelected(true);
        CoffeeManager.getInstance().getCurrentItem().setMilk(Dairy.NONE);
    }

    private void setDefaultSize() {
        mediumLabel.setSelected(true);
        CoffeeManager.getInstance().getCurrentItem().setSize(Size.MEDIUM);
    }

    @FXML
    void setSizeEvent(MouseEvent event) {
        RadioButton r = (RadioButton)event.getSource();
        CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().subtract(CoffeePrice.MEDIUM_COST));
        switch (r.getId()) {
            case "smallLabel":
                CoffeeManager.getInstance().getCurrentItem().setSize(Size.SMALL);
                CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.SMALL_COST));
                break;
            case "mediumLabel":
                CoffeeManager.getInstance().getCurrentItem().setSize(Size.MEDIUM);
                CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.MEDIUM_COST));
                break;
            case "largeLabel":
                CoffeeManager.getInstance().getCurrentItem().setSize(Size.LARGE);
                CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.LARGE_COST));
                break;
        }
    }

    @FXML
    void setDiaryEvent(MouseEvent event) {
        RadioButton r = (RadioButton)event.getSource();
        switch (r.getId()) {
            case "noDairyLabel":
                Platform.runLater(new EditDairyTask(Dairy.NONE));
                break;
            case "wholeLabel":
                Platform.runLater(new EditDairyTask(Dairy.WHOLE));
                break;
            case "_2percentLabel":
                Platform.runLater(new EditDairyTask(Dairy._2PERCENT));
                break;
            case "nonFatLabel":
                Platform.runLater(new EditDairyTask(Dairy.SKIM));
                break;
            case "soyLabel":
                Platform.runLater(new EditDairyTask(Dairy.SOY));
                break;
            case "almondLabel":
                Platform.runLater(new EditDairyTask(Dairy.ALMOND));
                break;
        }
    }
    /*
     switch (r.getId()) {
            case "noDairyLabel":
                if (CartManager.GetInstance().GetCurrentItem().getMilk() != Dairy.SOY || CartManager.GetInstance().GetCurrentItem().getMilk() != Dairy.ALMOND) {
                    CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().subtract(CoffeePrice.DAIRY_COST));
                } else {
                    CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().subtract(CoffeePrice.NON_DAIRY_COST));
                }
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy.NONE);
                break;
            case "wholeLabel":
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy.WHOLE);
                CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.DAIRY_COST));
                break;
            case "_2percentLabel":
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy._2PERCENT);
                CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.DAIRY_COST));
                break;
            case "nonFatLabel":
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy.SKIM);
                CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.DAIRY_COST));
                break;
            case "soyLabel":
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy.SOY);
                CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.NON_DAIRY_COST));
                break;
            case "almondLabel":
                CartManager.GetInstance().GetCurrentItem().setMilk(Dairy.ALMOND);
                CartManager.GetInstance().GetCurrentItem().setPrice(CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.NON_DAIRY_COST));
                break;
        }
     */


    private void AddEventHandlerForCheckbox(CheckBox cb) {
        EventHandler<ActionEvent> event = actionEvent -> {
            //temporary
            if (cb.isSelected()) {
                switch (cb.getId()) {
                    case "caramelCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.CARAMEL);
                        break;
                    case "mochaCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.MOCHA);
                        break;
                    case "vanillaCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.VANILLA);
                        break;
                    case "pumpkinCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.PUMPKIN_SPICE);
                        break;
                    case "hazelnutCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.HAZELNUT);
                        break;
                    case "coconutCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().addFlavor(Flavor.COCONUT);
                        break;
                }
                CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.FLAVOR_COST));
            } else {
                switch (cb.getId()) {
                    case "caramelCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.CARAMEL);
                        break;
                    case "mochaCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.MOCHA);
                        break;
                    case "vanillaCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.VANILLA);
                        break;
                    case "pumpkinCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.PUMPKIN_SPICE);
                        break;
                    case "hazelnutCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.HAZELNUT);
                        break;
                    case "coconutCheckBox":
                        CoffeeManager.getInstance().getCurrentItem().removeFlavor(Flavor.COCONUT);
                        break;
                }
                CoffeeManager.getInstance().getCurrentItem().setPrice(CoffeeManager.getInstance().getCurrentItem().getPrice().subtract(CoffeePrice.FLAVOR_COST));
            }
        };
        cb.setOnAction(event);
    }

}


