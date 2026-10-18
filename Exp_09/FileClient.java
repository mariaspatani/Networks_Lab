import java.io.*;
import java.net.*;
import java.util.*;

public class FileClient {
    public static void main(String[] args) throws Exception {

        // Connect to server at port 5000
        Socket s = new Socket("localhost", 5000);

        // Receive response from server
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        // Send filename to server
        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        // Read filename from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");

        // Send the filename to the server
        out.println(sc.nextLine());

        // Receive and display the server response
        String line;
        while ((line = in.readLine()) != null) {

            // Stop when the end marker is received
            if (line.equals("EOF"))
                break;

            System.out.println(line);
        }

        // Close connection
        s.close();
    }
}
