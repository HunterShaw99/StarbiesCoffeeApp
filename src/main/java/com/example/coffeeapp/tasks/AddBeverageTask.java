package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;

import java.util.UUID;

public class AddBeverageTask implements Runnable {

    private UUID toAdd;

    public AddBeverageTask(UUID mID) {
        toAdd = mID;
    }

    @Override
    public void run() {
        CoffeeModel m = CartManager.GetInstance().GetBeverage(toAdd);
        m.setItemID(UUID.randomUUID());
        CartManager.GetInstance().AddBeverage(m);
        System.out.println(m.toString());
        m = null;
    }
}
