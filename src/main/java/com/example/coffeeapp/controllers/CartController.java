package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.data.models.constants.Dairy;
import com.example.coffeeapp.data.models.constants.Flavor;
import com.example.coffeeapp.data.models.constants.Size;
import com.example.coffeeapp.observer.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.math.BigDecimal;

import static com.example.coffeeapp.data.models.constants.CoffeePrice.MEDIUM_COST;

public class CartController implements Observer {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Label menuLabel, totalLabel, totalValueLabel;

    @FXML
    private ListView<CoffeeModel> menuListView;

    @FXML
    private Pane menuPane;

    private byte init = 0;

    public void initialize() {

        if (init == 0) {
            menuListView.setItems(CartManager.GetInstance().GetCartItems());
            menuListView.setCellFactory(new CartCellFactory());
            totalValueLabel.setText("");
            CartManager.GetInstance().registerObserver(this);
            init++;
        }
    }

    @FXML
    void AddBevCart(MouseEvent event) {
        CoffeeModel m = new CoffeeModel();
        m.setName("Cold Brew a");
        m.setPrice(MEDIUM_COST);
        m.setMilk(Dairy.SOY);
        m.setSize(Size.MEDIUM);
        m.addFlavor(Flavor.PUMPKIN_SPICE);
        m.addFlavor(Flavor.VANILLA);
        m.addFlavor(Flavor.COCONUT);
        m.addFlavor(Flavor.MOCHA);
        CartManager.GetInstance().AddBeverage(m);
        System.out.println(m);
    }

    @FXML
    void MenuEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(0);
    }

    @FXML
    void CartEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(3);
    }

    @FXML
    void FavEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(1);
    }

    @FXML
    void RecentsEvent(MouseEvent event) throws IOException {
        ControllerHandler.GetInstance().Transition(2);
    }



    @Override
    public void update(BigDecimal total) {
        //Will update the cart total here when an item is added/removed in CartManager class
        totalValueLabel.setText("$"+total);
    }
}
