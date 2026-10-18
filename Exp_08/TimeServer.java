import java.net.*;
import java.util.*;

class TimeServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        System.out.println("Time Server Started");

        while (true) {
            byte[] buf = new byte[100];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp); // Receive request

            new Thread(() -> {
                try {
                    // Get server time
                    byte[] data = new Date().toString().getBytes();

                    // Send time to client
                    DatagramPacket reply = new DatagramPacket(
                        data, data.length, dp.getAddress(), dp.getPort());
                    ds.send(reply);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
