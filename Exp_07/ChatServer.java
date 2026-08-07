import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started...");
            System.out.println("Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected.");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);

                Thread t = new Thread(client);
                t.start();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class ClientHandler implements Runnable {

        Socket socket;
        BufferedReader in;
        PrintWriter out;
        String name;

        ClientHandler(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public void run() {

            try {
                name = in.readLine();

                broadcast("** " + name + " joined the chat **", this);

                String message;

                while ((message = in.readLine()) != null) {

                    if (message.equalsIgnoreCase("exit"))
                        break;

                    broadcast(name + ": " + message, this);
                }

                clients.remove(this);

                broadcast("** " + name + " left the chat **", this);

                socket.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static void broadcast(String message, ClientHandler sender) {

        for (ClientHandler client : clients) {

            if (client != sender) {
                client.out.println(message);
            }
        }

        System.out.println(message);
    }
}
