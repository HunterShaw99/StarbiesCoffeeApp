module com.example.coffeeapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coffeeapp to javafx.fxml;
    exports com.example.coffeeapp;
}
