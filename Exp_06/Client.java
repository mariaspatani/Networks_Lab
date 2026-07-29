// Import networking classes for UDP communication
import java.net.*;

// Import Scanner class for user input
import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {

        // Create a UDP socket for the client
        DatagramSocket clientSocket = new DatagramSocket();

        // Create Scanner object to read input from keyboard
        Scanner sc = new Scanner(System.in);

        // Read the sentence from the user
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Convert the sentence into bytes
        // UDP sends data in the form of byte arrays
        byte[] sendData = sentence.getBytes();

        // Get the IP address of the server
        // "localhost" means the server is running on the same computer
        InetAddress serverIP = InetAddress.getByName("localhost");

        // Create a DatagramPacket containing:
        // 1. Data to send
        // 2. Length of data
        // 3. Server IP Address
        // 4. Server Port Number (9002)
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, serverIP, 9002);

        // Send the packet to the server
        clientSocket.send(sendPacket);

        // Create a byte array to receive translated data
        byte[] receiveData = new byte[1024];

        // Create an empty packet to store received data
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);

        // Receive the translated sentence from the server
        clientSocket.receive(receivePacket);

        // Convert received bytes into a String
        String translated =
                new String(receivePacket.getData(), 0, receivePacket.getLength());

        // Display translated sentence
        System.out.println("\nTranslated Sentence:");
        System.out.println(translated);

        // Close the socket
        clientSocket.close();

        // Close Scanner
        sc.close();
    }
}
