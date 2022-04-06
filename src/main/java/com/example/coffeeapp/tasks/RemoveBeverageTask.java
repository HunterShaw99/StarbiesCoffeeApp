package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;

import java.util.UUID;

public class RemoveBeverageTask implements Runnable {

    private UUID itemID;

    public RemoveBeverageTask(UUID ID) {
        itemID = ID;
    }
    @Override
    public void run() {
        CartManager.GetInstance().RemoveBeverage(CartManager.GetInstance().GetBeverage(itemID));
    }
}
