import java.net.*;

class TimeClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        // Send time request
        byte[] data = "TIME".getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 5000);
        ds.send(dp);

        // Receive server time
        data = new byte[100];
        dp = new DatagramPacket(data, data.length);
        ds.receive(dp);

        System.out.println("Server Time: " +
            new String(dp.getData(), 0, dp.getLength()));

        ds.close();
    }
}
