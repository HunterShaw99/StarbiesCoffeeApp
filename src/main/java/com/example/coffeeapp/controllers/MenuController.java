package com.example.coffeeapp.controllers;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.NetworkManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.data.models.constants.CoffeePrice;
import com.example.coffeeapp.tasks.ViewChangeTask;
import com.example.coffeeapp.utility.ImageUrl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    @FXML
    private HBox bottomHBox;

    @FXML
    private Button logoutBtn, cartBtn, favBtn, menuBtn, recentBtn;

    @FXML
    private ImageView logoutImg;


    @FXML
    private Label menuLabel;

    @FXML
    private ListView<?> menuListView;

    @FXML
    private Pane menuPane;

    private Scene scene;
    private Parent root;
    private Stage stage;

    public void initialize() {

    }

    @FXML
    void MenuEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(0));
    }

    @FXML
    void CartEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(3));
    }

    @FXML
    void FavEvent(MouseEvent event) {Platform.runLater(new ViewChangeTask(1));}

    @FXML
    void RecentsEvent(MouseEvent event) {
        Platform.runLater(new ViewChangeTask(2));
    }


    @FXML
    void LogoutEvent(MouseEvent event) throws IOException {
        NetworkManager.getInstance().closeConnection();
        Platform.runLater(new ViewChangeTask(4));
    }

    @FXML
    void CustomizeEvent(MouseEvent event) throws IOException {
        String name = ((Button)event.getSource()).getText();
        String imageUrl = "";
        switch (name) {
            case "Coldbrew":
                imageUrl = ImageUrl.COLDBREW_URL;
                break;
            case "Iced Americano":
                imageUrl = ImageUrl.ICED_AMERICANO;
                break;
            case "Iced Cuppaccino":
                imageUrl = ImageUrl.ICED_CAP;
                break;
            case "Iced Macchiato":
                imageUrl = ImageUrl.ICED_MACH;
                break;
            case "Iced Latte":
                imageUrl = ImageUrl.ICED_LATTE;
                break;
            case "Iced Coffee":
                imageUrl = ImageUrl.ICED_COFFEE;
                break;
            case "Americano":
                imageUrl = ImageUrl.AMERC;
                break;
            case "Cuppaccino":
                imageUrl = ImageUrl.CAP;
                break;
            case "Macchiato":
                imageUrl = ImageUrl.MACH;
                break;
            case "Cafe Latte":
                imageUrl = ImageUrl.LATTE;
                break;
            case "Drip Coffee":
                imageUrl = ImageUrl.COFFEE;
                break;
            case "Espresso Shot":
                imageUrl = ImageUrl.SHOT;
        }
        CoffeeModel m = new CoffeeModel(imageUrl, CoffeePrice.MEDIUM_COST);
        m.setName(name);
        CoffeeManager.getInstance().setCurrentItem(m);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customization-view.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        ControllerHandler.GetInstance().SetStage(stage);

    }

}
