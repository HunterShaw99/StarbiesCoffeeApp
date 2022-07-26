package com.example.user;

import com.example.coffeeapp.data.models.CoffeeData;
import com.example.coffeeapp.data.models.FavData;
import com.example.coffeeapp.data.models.RecentsData;
import com.example.data.models.CoffeeModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class UserThread extends Thread implements Serializable {

    private Socket userSocket;
    private ObjectInputStream userInputStream;
    private ObjectOutputStream userOutputStream;

    private CoffeeData[] data;
    private int userID;
    private String userName;

    public UserThread(Socket userSocket, int userID, String userName, ObjectInputStream in) throws IOException {
        this.userSocket = userSocket;
        this.userID = userID;
        this.userName = userName;
        userInputStream = in;
        userOutputStream = new ObjectOutputStream(userSocket.getOutputStream());
        userOutputStream.flush();
        data = new CoffeeData[2];
    }

    public void sendFav() throws IOException {
        userOutputStream.writeObject(data);
    }
    public void sendRecent() throws IOException{
        userOutputStream.writeObject(data[1]);
    }

    public void getData(CoffeeData d) throws IOException, ClassNotFoundException {
        if (d.isFav) {
            data[0] = d;
            System.out.println(((FavData)data[0]).getFavs());
        }
        else {
            data[1] = d;
            System.out.println(((RecentsData)data[1]).getRecents());
        }


    }

    public ObjectInputStream getUserInputStream() {
        return userInputStream;
    }

    public ObjectOutputStream getUserOutputStream() {
        return userOutputStream;
    }

    public int getUserID() {
        return userID;
    }

    public void run() {
        boolean alive = true;
        while (alive) {
             CoffeeData d = null;
            try {
                d = (CoffeeData) userInputStream.readObject();
                getData(d);
                if(d.isFav == false) sendFav();

                //sendRecent();
                userOutputStream.flush();
            }
            catch (ClassNotFoundException e)  {
                System.out.println("Error receiving message....shutting down");
                alive =false;
            }
            catch (IOException e)
            {
                //System.out.println("No data");
                //alive = false;
            }
        }
    }

}

