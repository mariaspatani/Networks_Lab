# Experiment 08: Concurrent Time Server using UDP in Java

## Aim

To implement a **Concurrent Time Server** using **UDP (User Datagram Protocol)** in Java. The client sends a time request to the server, and the server returns its current system date and time. The client receives and displays the time returned by the server.

---

## Theory

**UDP (User Datagram Protocol)** is a connectionless transport layer protocol. Unlike TCP, UDP does not establish a connection before sending data. Data is transmitted as **datagrams (packets)**, making communication faster with lower overhead.

In this experiment, the server listens on **port 5000** for incoming UDP requests. Whenever a client sends the message `"TIME"`, the server creates a separate thread to handle that client, obtains the current system time, and sends it back to the client.

The use of **threads** makes the server **concurrent**, allowing it to serve multiple clients simultaneously.

---

## Concepts Used

- **DatagramSocket** – Communication endpoint used in UDP.
- **DatagramPacket** – Packet used to send and receive data.
- **InetAddress** – Represents the IP address of the destination host.
- **Thread** – Executes each client request independently for concurrent communication.
- **Date** – Retrieves the current system date and time.

---

## How the Program Works

1. The server creates a `DatagramSocket` and listens on port **5000**.
2. The client creates a UDP socket and sends the message `"TIME"` to the server.
3. The server receives the request packet.
4. The server creates a **new thread** for the client request.
5. The thread obtains the current system time using `Date`.
6. The server sends the time back to the client's IP address and port.
7. The client receives the response and displays the server time.

---

## Algorithm

### Server Algorithm

1. Create a UDP socket on port 5000.
2. Wait continuously for client requests using `receive()`.
3. When a request arrives, create a new thread.
4. Get the current system date and time.
5. Create a reply packet using the client's address and port.
6. Send the reply packet to the client.
7. Continue waiting for new client requests.

### Client Algorithm

1. Create a UDP socket.
2. Convert `"TIME"` into bytes.
3. Send the request packet to the server on port 5000.
4. Wait for the server's response.
5. Convert the received bytes into a string.
6. Display the received server time.
7. Close the socket.

---

## Code Explanation

### Server Code Explanation

| Code | Explanation |
|------|-------------|
| `DatagramSocket socket = new DatagramSocket(5000);` | Creates a UDP socket and listens on port 5000. |
| `while(true)` | Keeps the server running continuously. |
| `socket.receive(request);` | Waits until a client sends a packet. |
| `new Thread(() -> {...}).start();` | Creates a separate thread to handle each client request concurrently. |
| `new Date().toString()` | Retrieves the current system date and time. |
| `getBytes()` | Converts the time string into bytes for transmission. |
| `request.getAddress()` | Gets the client's IP address. |
| `request.getPort()` | Gets the client's port number. |
| `socket.send(reply);` | Sends the current time back to the client. |

### Client Code Explanation

| Code | Explanation |
|------|-------------|
| `DatagramSocket socket = new DatagramSocket();` | Creates the client UDP socket. |
| `"TIME".getBytes()` | Converts the request message into bytes. |
| `InetAddress.getByName("localhost")` | Specifies the server address (same computer). |
| `socket.send(packet)` | Sends the time request to the server. |
| `socket.receive(reply)` | Waits for the server's response. |
| `new String(reply.getData(),0,reply.getLength())` | Converts received bytes into a readable string. |
| `socket.close()` | Closes the UDP socket. |

---

## Why is Thread Used?

The experiment specifies a **Concurrent Time Server**.

A concurrent server should handle multiple clients without making one client wait for another. Therefore, the server creates a **new thread** whenever a request is received.

**Without Thread:**
- Server handles one request at a time.
- Next client waits until the previous request is completed.

**With Thread:**
- Every client request is processed independently.
- Server immediately returns to listening for new requests.
- Multiple clients can receive responses simultaneously.

---

## UDP vs TCP Comparison

| UDP | TCP |
|-----|-----|
| Connectionless protocol. | Connection-oriented protocol. |
| Faster communication. | Slightly slower due to connection setup. |
| No acknowledgement or retransmission. | Reliable delivery with acknowledgement. |
| Data sent as datagrams. | Data sent as a continuous stream. |
| Lower overhead. | Higher overhead. |
| Suitable for DNS, streaming, VoIP, time server. | Suitable for file transfer, email, web applications. |

---

## DatagramSocket vs DatagramPacket

| DatagramSocket | DatagramPacket |
|---------------|----------------|
| Communication endpoint in UDP. | Container for sending and receiving data. |
| Used to send and receive packets. | Stores data, IP address, and port number. |
| Can be bound to a port number. | Represents a single UDP message. |

---

## Important Methods Used

| Method | Purpose |
|--------|---------|
| `receive()` | Receives a UDP packet from a client. |
| `send()` | Sends a UDP packet to a client. |
| `getAddress()` | Returns the sender's IP address. |
| `getPort()` | Returns the sender's port number. |
| `getData()` | Returns the packet's byte array. |
| `getLength()` | Returns the actual number of received bytes. |
| `getBytes()` | Converts a string into bytes. |
| `new String()` | Converts bytes back into a string. |

---

## Sample Execution

### Server Output

```text
Server Running...
```

### Client Output

```text
Server Time: Sat Sep 26 23:35:12 IST 2026
```

---

## Advantages of UDP Time Server

- Faster communication because UDP is connectionless.
- Simple implementation.
- Supports concurrent client requests using threads.
- Less communication overhead compared to TCP.

---

## Limitations

- UDP does not guarantee delivery of packets.
- Packets may be lost or arrive out of order.
- No acknowledgement or error recovery mechanism.

---

## Result

The Concurrent Time Server using UDP was implemented successfully. The client sent a time request to the server, received the current system time, and displayed it successfully.

---

## Conclusion (Course Outcome)

The experiment successfully demonstrated UDP-based client-server communication using Java. A concurrent server was implemented using threads to handle multiple client requests simultaneously, achieving reliable execution of the UDP Time Server application.

---

# Viva Questions and Answers

### 1. What is UDP?

UDP (User Datagram Protocol) is a connectionless transport layer protocol used for fast communication without establishing a connection.

### 2. Why is UDP used in this experiment?

UDP provides faster communication with less overhead because no connection establishment is required.

### 3. What is a DatagramSocket?

`DatagramSocket` is the communication endpoint used to send and receive UDP packets.

### 4. What is a DatagramPacket?

`DatagramPacket` is the packet that contains data, destination/source IP address, and port number.

### 5. Why is port 5000 used?

Port 5000 is the server's listening port where client requests are received.

### 6. What does `while(true)` do?

It keeps the server running continuously so it can serve multiple client requests.

### 7. Why is Thread used?

Thread is used to make the server concurrent by handling each client request independently while the server continues listening for new requests.

### 8. Is Thread compulsory in UDP?

No. UDP does not require threads. Thread is used only to implement concurrency in the server.

### 9. What does `getAddress()` return?

It returns the IP address of the client that sent the request.

### 10. What does `getPort()` return?

It returns the client's port number.

### 11. Why is `getBytes()` used?

UDP transmits data as bytes, so strings must be converted into byte arrays.

### 12. Why is `new String(getData(),0,getLength())` used?

It converts only the received bytes into a readable string and avoids printing extra empty bytes.

### 13. What is `InetAddress.getByName("localhost")`?

It returns the IP address of the local machine (127.0.0.1).

### 14. What is the difference between `getData()` and `getLength()`?

`getData()` returns the entire byte array, while `getLength()` returns the actual number of bytes received.

### 15. What is concurrency?

Concurrency means executing multiple client requests independently at the same time using separate threads.

### 16. What happens if Thread is removed?

The server still works, but it handles only one client request at a time.

### 17. Which layer does UDP belong to?

UDP belongs to the **Transport Layer** of the TCP/IP model.

### 18. Which protocol is faster, TCP or UDP?

UDP is generally faster because it does not establish a connection or provide acknowledgement.

### 19. Give one real-life application of UDP.

DNS, live video streaming, VoIP, online gaming, and time synchronization services use UDP.

### 20. Why is UDP called connectionless?

Because data is sent without establishing a connection between the client and server before communication.

