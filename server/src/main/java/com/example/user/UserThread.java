package com.example.user;

import com.example.data.models.CoffeeModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

public class UserThread extends Thread implements Serializable {

    private Socket userSocket;
    private ObjectInputStream userInputStream;
    private ObjectOutputStream userOutputStream;

    private List<CoffeeModel> favLIST;
    private List<CoffeeModel> recentLIST;
    private int userID;
    private String userName;

    public UserThread(Socket userSocket, int userID, String userName, ObjectInputStream in) throws IOException {
        this.userSocket = userSocket;
        this.userID = userID;
        this.userName = userName;
        userInputStream = in;
        userOutputStream = new ObjectOutputStream(userSocket.getOutputStream());
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
}

