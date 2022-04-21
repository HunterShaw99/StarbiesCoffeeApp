package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;

import java.util.UUID;

public class FavAddTask implements Runnable {

    private UUID id;

    public FavAddTask(UUID id) {
        this.id = id;
    }

    @Override
    public void run() {
        CoffeeModel m = CoffeeManager.getInstance().getBeverageCart(id);
        CoffeeManager.getInstance().addBeverageFav(m);
    }
}
