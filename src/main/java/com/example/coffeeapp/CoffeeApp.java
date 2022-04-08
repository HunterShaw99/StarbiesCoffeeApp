package com.example.coffeeapp;

import com.example.coffeeapp.controllers.ControllerHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class CoffeeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Stardoes Coffee");
        ControllerHandler.GetInstance().SetStage(stage);
        ControllerHandler.GetInstance().Transition(0);
    }

    public static void main(String[] args) {
        launch();
    }
}