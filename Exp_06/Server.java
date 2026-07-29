// Import networking classes
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        // Create a UDP socket on port number 9002
        DatagramSocket serverSocket = new DatagramSocket(9002);

        // Display server status
        System.out.println("Server is waiting for client message...");

        // Create byte array to receive data
        byte[] receiveData = new byte[1024];

        // Create DatagramPacket to store incoming packet
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);

        // Wait until a client sends a message
        serverSocket.receive(receivePacket);

        // Convert received bytes into String
        String sentence =
                new String(receivePacket.getData(), 0, receivePacket.getLength());

        // Display received sentence
        System.out.println("Received Sentence:");
        System.out.println(sentence);

        // Replace abbreviations with formal English

        sentence = sentence.replace("tbh", "to be honest");
        sentence = sentence.replace("ig", "I guess");
        sentence = sentence.replace("tbf", "to be fair");
        sentence = sentence.replace("atm", "at the moment");
        sentence = sentence.replace("irl", "in real life");
        sentence = sentence.replace("lol", "laugh out loud");
        sentence = sentence.replace("asap", "as soon as possible");
        sentence = sentence.replace("omg", "oh my god");
        sentence = sentence.replace("ttyl", "talk to you later");
        sentence = sentence.replace("idk", "I don't know");
        sentence = sentence.replace("nvm", "never mind");

        // Display translated sentence on server
        System.out.println("\nTranslated Sentence:");
        System.out.println(sentence);

        // Convert translated sentence into bytes
        byte[] sendData = sentence.getBytes();

        // Create packet containing:
        // 1. Translated data
        // 2. Client IP Address
        // 3. Client Port Number
        DatagramPacket sendPacket =
                new DatagramPacket(
                        sendData,
                        sendData.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort());

        // Send translated sentence back to client
        serverSocket.send(sendPacket);

        // Close socket
        serverSocket.close();
    }
}
