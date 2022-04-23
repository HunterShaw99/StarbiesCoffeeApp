package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;

import java.util.UUID;

public class RecentsAddTask implements Runnable{

    private UUID id;

    public RecentsAddTask(UUID id) {
        this.id = id;
    }

    @Override
    public void run() {
        CoffeeModel m = CoffeeManager.getInstance().getBeverageCart(id);
        CoffeeManager.getInstance().addBeverageRecents(m);
    }
}
