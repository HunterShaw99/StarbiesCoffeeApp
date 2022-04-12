package com.example.coffeeapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TwoWayCommunicationClient implements Runnable{

    static final int PORT = 5001;
    Thread readThread;
    Thread writeThread;
    ObjectInputStream in;
    ObjectOutputStream out;
    Scanner scanner;
    Socket socket;
    String client;
    boolean running;

    public TwoWayCommunicationClient(String[] args){
        try{
//            if(args.length < 2){
//                System.out.println("Not enough arguments...terminating");
//            }else{

                InetAddress addr = InetAddress.getByName(args[0]);
                socket = new Socket(addr, PORT);
                scanner = new Scanner(System.in);
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();

                client = "client";

                String server = (String)in.readObject();
                out.writeObject(client);

                System.out.println("Communicate with : " + server);
                System.out.println("Type Stop to end");

                running = true;
                readThread = new Thread(this);
                readThread.start();
                writeThread = new Thread(this);
                writeThread.start();

        }
        catch(Exception e){
            System.out.println("Problem connecting");
        }
    }


    @Override
    public void run() {
        String MsgOut = new String("");
        String MsgIn = new String("");

        try{
            while((running) && (!MsgOut.equals("Stop"))){
                if(Thread.currentThread() == readThread){
                    MsgIn= (String)in.readObject();
                    System.out.println(MsgIn);
                }
                else if(Thread.currentThread() == writeThread){
                    MsgOut = scanner.nextLine();
                    out.writeObject(client + " : " + MsgOut);
                    out.flush();
                }
            }
            running = false;
            socket.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Error receiving message...shutting down");
            running = false;
        }
        catch(IOException e){
            System.out.println("Shutting down");
            running = false;
        }
    }
}
