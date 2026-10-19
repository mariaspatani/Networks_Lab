import java.net.*;
import java.io.*;
import java.util.*;

class ChatServer {
    static Vector<PrintWriter> v = new Vector<>();

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Started");

        while (true) {
            Socket s = ss.accept();
            new Thread(() -> {
                PrintWriter out = null; String name = "";
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out = new PrintWriter(s.getOutputStream(), true);
                    name = in.readLine(); v.add(out);
                    System.out.println(name + " joined the chat");
                    for (PrintWriter p : v) if (p != out) p.println(name + " joined the chat");

                    String msg;
                    while ((msg = in.readLine()) != null && !msg.equals("/exit"))
                        for (PrintWriter p : v) if (p != out) p.println(name + ": " + msg);
                } catch (Exception e) {
                } finally {
                    if (out != null) {
                        v.remove(out);
                        System.out.println(name + " left the chat");
                        for (PrintWriter p : v) p.println(name + " left the chat");
                    }
                    try { s.close(); } catch (Exception e) {}
                }
            }).start();
        }
    }
}
