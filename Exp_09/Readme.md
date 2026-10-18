## Concurrent File Server in Java

# Aim:
To develop a Concurrent File Server in Java that handles multiple clients simultaneously using multithreading. It sends the requested file contents if the file exists; otherwise, it sends an error message along with the server PID.

Requirements:
Java JDK, Terminal, ConcurrentFileServer.java, FileClient.java.

## Algorithm:
Server:
1. Create a server socket on port 5000.
2. Get and display the server PID.
3. Accept client connections continuously.
4. Create a new thread for each client.
5. Receive the requested filename.
6. Check whether the file exists.
7. Send the PID and file contents or an error message.
8. Close the connection.

Client:
1. Connect to the server.
2. Enter the filename.
3. Send the filename to the server.
4. Receive and display the response.
5. Close the connection.

Execution:
1. Compile:
   javac ConcurrentFileServer.java FileClient.java

2. Start the server:
   java ConcurrentFileServer

3. Run the client in another terminal:
   java FileClient

4. Enter a filename, e.g., test.txt.

Expected Output:

Server:
Concurrent File Server Started...
Server PID: 12345
Listening on port 5000
Client connected: /127.0.0.1
Requested file: test.txt

Client:
Enter filename: test.txt

--- Response from Server ---
Server PID: 12345
File Found
Hello World!

Result:
The Concurrent File Server was implemented successfully using Java socket programming and multithreading. It sends the server PID and requested file contents or an error message to the client.
