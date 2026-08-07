# 💬 Multi-User Chat Server using TCP in Java

A simple **Multi-User Chat Application** developed using **Java TCP Socket Programming**. The application allows multiple clients to connect to a server simultaneously and exchange messages in real time using multithreading.

---

# 📌 Objective

To implement a **multi-user chat server** using **TCP (Transmission Control Protocol)** in Java, where multiple clients can connect to a server simultaneously and exchange messages in real time.

---

# 🚀 Features

- Supports multiple clients simultaneously
- Real-time message broadcasting
- Client join and leave notifications
- Multi-threaded server
- Reliable communication using TCP
- Simple command-line interface

---

# 🛠 Technologies Used

- Java
- TCP Socket Programming
- Multithreading
- Java Networking (`java.net`)
- Java I/O (`java.io`)

---

# 📂 Project Structure

```
MultiUserChat/
│
├── ChatServer.java
├── ChatClient.java
└── README.md
```

---

# 📖 Algorithm

## Server Algorithm

1. Start the server.
2. Create a `ServerSocket` on port **5000**.
3. Display that the server has started.
4. Wait for incoming client connections.
5. Accept a client connection.
6. Create a `ClientHandler` object for the client.
7. Store the client in a list of connected clients.
8. Create a separate thread for the client.
9. Receive the client's username.
10. Broadcast a join message to other clients.
11. Receive messages continuously.
12. Broadcast every received message to all connected clients except the sender.
13. Remove the client when it disconnects.
14. Notify remaining clients that the user left the chat.
15. Continue waiting for new clients.

---

## Client Algorithm

1. Start the client.
2. Connect to the server.
3. Create input and output streams.
4. Enter the username.
5. Send the username to the server.
6. Create a thread to receive messages continuously.
7. Read messages from the keyboard.
8. Send messages to the server.
9. Continue chatting until `exit` is entered.
10. Close the connection.

---

# ⚙️ Code Explanation

## ChatServer.java

### 1. Creating the Server

The server creates a `ServerSocket` on port **5000** and waits for incoming client connections.

```java
ServerSocket serverSocket = new ServerSocket(5000);
```

---

### 2. Accepting Client Connections

Whenever a client connects, the server accepts the connection and creates a new `ClientHandler`.

```java
Socket socket = serverSocket.accept();
ClientHandler client = new ClientHandler(socket);
```

Each client is handled independently.

---

### 3. Multithreading

A separate thread is created for every connected client.

```java
Thread t = new Thread(client);
t.start();
```

This allows multiple clients to communicate simultaneously.

---

### 4. Receiving Username

The first message sent by the client is considered the username.

```java
name = in.readLine();
```

The server broadcasts that the client has joined.

---

### 5. Broadcasting Messages

Whenever a client sends a message, it is forwarded to every connected client except the sender.

```java
broadcast(name + ": " + message, this);
```

This enables real-time communication.

---

### 6. Handling Client Exit

If the client types **exit**, the server removes that client and broadcasts a leave message.

```java
clients.remove(this);
broadcast("** " + name + " left the chat **", this);
```

---

# ChatClient.java

### 1. Connecting to the Server

The client connects to the server using its IP address and port number.

```java
Socket socket = new Socket("localhost", 5000);
```

---

### 2. Sending Username

The username entered by the user is sent immediately after establishing the connection.

```java
out.println(name);
```

---

### 3. Receiving Messages

A separate thread continuously listens for messages from the server.

```java
Thread receiveThread = new Thread(() -> {
    ...
});
```

This allows the client to receive messages while simultaneously typing new ones.

---

### 4. Sending Messages

The client continuously reads input from the keyboard and sends it to the server.

```java
out.println(message);
```

---

### 5. Exiting

When the user enters **exit**, the socket is closed and the client terminates.

```java
socket.close();
```

---

# ▶️ Compilation

```bash
javac ChatServer.java ChatClient.java
```

---

# ▶️ Execution

Start the server.

```bash
java ChatServer
```

Open two or more terminals and run:

```bash
java ChatClient
```

Enter different usernames and start chatting.

---

# 📚 Concepts Used

- TCP Protocol
- Client-Server Architecture
- Socket Programming
- Multithreading
- Java Networking
- Message Broadcasting

---

# 🎯 Learning Outcomes

- Understand TCP communication.
- Learn Java socket programming.
- Implement multithreaded servers.
- Handle multiple client connections.
- Develop a real-time chat application.

---

# 📝 Result

Successfully implemented a **Multi-User Chat Server using TCP in Java**. Multiple clients were able to communicate simultaneously through a central server using TCP socket programming and multithreading.
