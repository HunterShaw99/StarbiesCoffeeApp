package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CoffeeManager;
import com.example.coffeeapp.data.models.constants.CoffeePrice;
import com.example.coffeeapp.data.models.constants.Dairy;

public class EditDairyTask implements Runnable {

    private Dairy dairy;

    public EditDairyTask(Dairy dairy) {
        this.dairy = dairy;
    }

    @Override
    public void run() {
        Dairy currentDiary = CoffeeManager.getInstance().getCurrentItem().getMilk();
        if (currentDiary == Dairy.ALMOND || currentDiary == Dairy.SOY) {
            CoffeeManager.getInstance().getCurrentItem().setPrice(
                    CoffeeManager.getInstance().getCurrentItem().getPrice().subtract(CoffeePrice.NON_DAIRY_COST)
            );
        } else if (currentDiary != Dairy.NONE){
            CoffeeManager.getInstance().getCurrentItem().setPrice(
                    CoffeeManager.getInstance().getCurrentItem().getPrice().subtract(CoffeePrice.DAIRY_COST)
            );
        }
        CoffeeManager.getInstance().getCurrentItem().setMilk(dairy);
        if (dairy == Dairy.ALMOND || dairy == Dairy.SOY) {
            CoffeeManager.getInstance().getCurrentItem().setPrice(
                    CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.NON_DAIRY_COST)
            );
        } else if (dairy != Dairy.NONE){
            CoffeeManager.getInstance().getCurrentItem().setPrice(
                    CoffeeManager.getInstance().getCurrentItem().getPrice().add(CoffeePrice.DAIRY_COST)
            );
        }
    }
}
