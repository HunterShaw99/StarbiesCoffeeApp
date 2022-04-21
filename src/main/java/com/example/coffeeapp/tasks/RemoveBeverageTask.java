package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CoffeeManager;

import java.util.UUID;

public class RemoveBeverageTask implements Runnable {

    private UUID itemID;

    public RemoveBeverageTask(UUID ID) {
        itemID = ID;
    }
    @Override
    public void run() {
        CoffeeManager.getInstance().removeBeverageCart(CoffeeManager.getInstance().getBeverageCart(itemID));
    }
}
