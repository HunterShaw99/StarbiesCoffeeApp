package com.example.coffeeapp.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StageManager {

    private static StageManager instance;
    private static List<Scene> views;
    private Stage stage;
    private Parent root;

    private StageManager(String menuURL, String favURL, String recentURL, String cartURL) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(menuURL));
        root = loader.load();
        Scene s = new Scene(root);
        views = new ArrayList<>(6);
    }

    public static StageManager GetInstance() {
        if (instance == null) {
            synchronized (StageManager.class) {
                if (instance == null) {
                    instance = new StageManager("com/example/coffeeapp/controllers/menu-view.fxml",
                            "com/example/coffeeapp/controllers/fav-view.fxml",
                            "com/example/coffeeapp/controllers/orderhistory-view.fxml",
                            "com/example/coffeeapp/controllers/cart-view.fxml");
                }
            }
        }
        return instance;
    }

    public void TransitionScene(int sceneVal) {

    }

    private void MenuScene() {

    }

    private void FavScene() {

    }

    private void RecentScene() {

    }

    private void CartScene() {

    }
}
