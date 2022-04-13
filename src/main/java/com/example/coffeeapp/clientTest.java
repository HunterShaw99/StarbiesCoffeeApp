package com.example.coffeeapp;

import java.io.IOException;
import com.example.coffeeapp.TwoWayCommunicationClient;

public class clientTest {
    public static void main(String[] args) throws IOException {

        String[] test = new String[1];
        test[0]= "client";
        TwoWayCommunicationClient C = new TwoWayCommunicationClient(test);
    }
}
