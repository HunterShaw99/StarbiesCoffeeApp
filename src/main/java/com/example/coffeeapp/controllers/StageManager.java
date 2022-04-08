package com.example.coffeeapp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.coffeeapp.utility.SceneUrl.*;

public class StageManager {

    private static volatile StageManager instance;
    private List<Scene> views;
    private Parent root;
    private final int X = 600;
    private final int Y = 800;
    private Stage stage;

    private StageManager() throws IOException {
        views = new ArrayList<>(5);
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource(MENU_URL));
        views.add(new Scene(root, X, Y));
        root = loader.load(getClass().getResource(FAV_URL));
        views.add(new Scene(root, X, Y));
        root = loader.load(getClass().getResource(RECENT_URL));
        views.add(new Scene(root, X, Y));
        root = loader.load(getClass().getResource(CART_URL));
        views.add(new Scene(root, X, Y));
    }

    public static StageManager GetInstance() throws IOException {
        if (instance == null) {
            synchronized (StageManager.class) {
                if (instance == null) {
                    instance = new StageManager();
                }
            }
        }
        return instance;
    }

    public void Transition(int sceneNum) {
        if (sceneNum > views.size()-1) {
            return;
        }
        stage.setScene(views.get(sceneNum));
        stage.show();
    }

    public void SetStage(Stage stage) {
        this.stage = stage;
    }

}
