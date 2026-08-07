import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            out.println(name);

            Thread receiveThread = new Thread(() -> {

                try {

                    String msg;

                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }

                } catch (Exception e) {
                }

            });

            receiveThread.start();

            while (true) {

                String message = sc.nextLine();

                out.println(message);

                if (message.equalsIgnoreCase("exit"))
                    break;
            }

            socket.close();
            sc.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
