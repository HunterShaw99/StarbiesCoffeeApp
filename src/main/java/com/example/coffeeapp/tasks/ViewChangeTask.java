package com.example.coffeeapp.tasks;

import com.example.coffeeapp.controllers.ControllerHandler;

import java.io.IOException;

public class ViewChangeTask implements Runnable {

    private final int viewIndex;

    public ViewChangeTask(int viewVal) {
        viewIndex = viewVal;
    }
    @Override
    public void run() {
        try {
            ControllerHandler.GetInstance().Transition(viewIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
