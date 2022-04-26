package com.example.coffeeapp.data;

import com.example.coffeeapp.data.models.CoffeeModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkManager {


    private volatile static NetworkManager instance = null;

    private volatile static Socket client;

    private Object data[];

    private static ObjectInputStream oiStream;
    private static ObjectOutputStream ooStream;

    private NetworkManager() {
        //Sets a Object array to size 2, in case we want to keep things simple and just use this for data transfer
        data = new Object[2];
    }

    public static NetworkManager getInstance() {
        if (instance == null) {
            synchronized (CoffeeManager.class) {
                if (instance == null) {
                    instance = new NetworkManager();
                }
            }
        }
        return instance;
    }

    private void setOiStream() throws IOException, ClassNotFoundException {
        oiStream = new ObjectInputStream(client.getInputStream());
        String x = (String)oiStream.readObject();
        System.out.println(x);
    }

    private void setOoStream() throws IOException {
        ooStream = new ObjectOutputStream(client.getOutputStream());
        //ooStream.writeObject("Hello, Server");
        CoffeeModel cf = new CoffeeModel(CoffeeManager.getInstance().getRecentLIST().get(0));
        System.out.println("Writing coffemodel " + cf);
        System.out.println(cf.getClass());
        ooStream.writeObject(cf);
    }

    public void setClient(Socket client) throws IOException, ClassNotFoundException {
        this.client = client;
        System.out.println("Set Client to "+ this.client);
        setOoStream(); //Set the ObjectOutput stream
        setOiStream(); //Set the ObjectInput stream

    }

    public void closeConnection() throws IOException {
        System.out.println("Closing client "+ this.client);
        client.close();
    }
}
