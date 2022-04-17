module com.example.coffeeapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coffeeapp to javafx.fxml;
    exports com.example.coffeeapp;
    exports com.example.coffeeapp.controllers;
    opens com.example.coffeeapp.controllers to javafx.fxml;
    exports com.example.coffeeapp.utility;
    opens com.example.coffeeapp.utility to javafx.fxml;
    exports com.example.coffeeapp.data.models;
    opens com.example.coffeeapp.data.models to javafx.fxml;
    exports com.example.coffeeapp.data;
    opens com.example.coffeeapp.data to javafx.fxml;
}
