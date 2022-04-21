package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.data.models.constants.Flavor;

public class CartAddTask implements Runnable {
    @Override
    public void run() {
        CoffeeModel m = CoffeeManager.getInstance().getCurrentItem();
        if (m.getFlavors().size() == 0) m.addFlavor(Flavor.NONE);
        CoffeeManager.getInstance().addBeverageCart(m);
        CoffeeManager.getInstance().setCurrentItem(null);
    }
}
