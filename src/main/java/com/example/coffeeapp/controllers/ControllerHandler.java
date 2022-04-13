package com.example.coffeeapp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.coffeeapp.utility.SceneUrl.*;

public class ControllerHandler {

    private static volatile ControllerHandler instance;
    private volatile Scene views[];
    private Parent root;
    private final int X = 600;
    private final int Y = 800;
    private static Stage stage;

    private ControllerHandler() throws IOException {
        views = new Scene[6];
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(Objects.requireNonNull(getClass().getResource(MENU_URL)));
        views[0] = new Scene(root, X, Y);
        root = loader.load(Objects.requireNonNull(getClass().getResource(FAV_URL)));
        views[1] = new Scene(root, X, Y);
        root = loader.load(Objects.requireNonNull(getClass().getResource(RECENT_URL)));
        views[2]= new Scene(root, X, Y);
        root = loader.load(getClass().getResource(CART_URL));
        views[3]= new Scene(root, X, Y);
        root = loader.load(Objects.requireNonNull(getClass().getResource(LOGIN_URL)));
        views[4] = new Scene(root, X, Y);
        root = loader.load(Objects.requireNonNull(getClass().getResource(ACCOUNT_URL)));
        views[5] = new Scene(root, X,Y);
    }

    public static ControllerHandler GetInstance() throws IOException {
        if (instance == null) {
            synchronized (ControllerHandler.class) {
                if (instance == null) {
                    instance = new ControllerHandler();
                }
            }
        }
        return instance;
    }

    public void Transition(int sceneNum) {
        stage.setScene(Get(sceneNum));
        stage.show();
    }

    public void SetStage(Stage stage) {
        this.stage = stage;
    }

    private Scene Get(int index) {
        for (int i = 0; i < 6; i++) {
            if (i == index) {
                return views[i];
            }
        }
        return null;
    }

}
