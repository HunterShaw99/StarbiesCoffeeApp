import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

public class TwoWayCommunicationServer implements Runnable{
    public static final int PORT = 5001;
    Thread readThread;
    Thread writeThread;
    ObjectOutputStream out;
    ObjectInputStream in;
    Scanner scanner;
    String server;
    boolean running;

    public TwoWayCommunicationServer(String args[]) throws IOException{
        if (args.length < 1){
            System.out.println("Not enough arguments...terminating");
        }
        else{
            ServerSocket s = new ServerSocket(PORT);
            server = "server";
            System.out.println(server + " writing "+ ". Waiting for client");
            try{
                Socket socket = s.accept();
                scanner = new Scanner(System.in);
                out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();
                in = new ObjectInputStream(socket.getInputStream());

                out.writeObject(server);
                String client = (String) in.readObject();

                System.out.println("reading from " + client);
                running = true;
                readThread = new Thread(this);
                readThread.start();
                writeThread = new Thread(this);
                writeThread.start();
            }catch (Exception e){
                System.out.println("Server Shutting down");
                s.close();
            }
        }
    }

    @Override
    public void run() {
        try{
            while (running){
                if(Thread.currentThread() == readThread){
                    String MsgIn = (String) in.readObject();
                    System.out.println(MsgIn);
                }
                else if(Thread.currentThread() == writeThread){
                    String MsgOut = scanner.nextLine();
                    out.writeObject(server + " : " + MsgOut);
                    out.flush();
                }
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Error recieving message ... shutting down");
            running = false;
        }
        catch (IOException e){
            System.out.println("Client has left...shutting down");
            running = false;
        }
    }
}
