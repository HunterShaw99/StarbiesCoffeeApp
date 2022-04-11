package com.example.coffeeapp;

import com.example.coffeeapp.controllers.ControllerHandler;
import com.example.coffeeapp.tasks.ViewChangeTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class CoffeeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Stardoes Coffee");
        ControllerHandler.GetInstance().SetStage(stage);
        Platform.runLater(new ViewChangeTask(4));
    }

    public static void main(String[] args) {
        launch();
    }
}
