# 🔗 TCP Client–Server Communication Using Java

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge">
  <img src="https://img.shields.io/badge/Protocol-TCP-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Socket%20Programming-Java-success?style=for-the-badge">
  <img src="https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge">
</p>

---

## 📖 Overview

This project demonstrates **TCP Client–Server Communication** using **Java Socket Programming**.

The **client** generates a random square matrix of order **N** with values ranging from **1 to 50**, randomly converts it into one of the following matrix types:

- Upper Triangular Matrix
- Lower Triangular Matrix
- Diagonal Matrix
- Normal Matrix

The matrix is transmitted to the **server**, where it is analyzed. The server determines the matrix type and sends the result back to the client using the **TCP protocol**.

---

# 🎯 Aim

To implement a **TCP-based Client–Server communication** system in Java where:

- The client generates a random matrix.
- The matrix is sent to the server.
- The server identifies the matrix type.
- The identified result is returned to the client.

---

# ✨ Features

✔ TCP Socket Programming

✔ Reliable Client–Server Communication

✔ Random Matrix Generation

✔ Automatic Matrix Classification

✔ Object Transmission using Object Streams

✔ Console-Based Execution

✔ Simple and Beginner Friendly

---

# 🛠 Technologies Used

- Java
- TCP Protocol
- Java Socket Programming
- ObjectInputStream
- ObjectOutputStream
- DataInputStream
- DataOutputStream
- Random Class
- Scanner Class

---

# 📂 Project Structure

```
TCP-Client-Server/
│
├── Client.java
├── Server.java
├── README.md
```

---

# ⚙️ How It Works

## 🖥 Client

1. Creates a TCP socket.
2. Connects to the server.
3. Reads matrix order (N).
4. Generates an NxN random matrix.
5. Converts it randomly into:
   - Upper Triangular
   - Lower Triangular
   - Diagonal
   - Normal Matrix
6. Displays the generated matrix.
7. Sends the matrix to the server.
8. Receives the matrix type.
9. Displays the result.
10. Closes the connection.

---

## 💻 Server

1. Creates a ServerSocket.
2. Waits for client connection.
3. Accepts the connection.
4. Receives the matrix.
5. Checks whether it is:
   - Upper Triangular
   - Lower Triangular
   - Diagonal
   - Normal Matrix
6. Sends the identified type back to the client.
7. Closes the socket.

---

# 📐 Matrix Types

## Upper Triangular Matrix

All elements below the main diagonal are zero.

```
5 7 2
0 4 6
0 0 8
```

---

## Lower Triangular Matrix

All elements above the main diagonal are zero.

```
5 0 0
4 8 0
7 3 6
```

---

## Diagonal Matrix

Only diagonal elements are non-zero.

```
5 0 0
0 8 0
0 0 6
```

---

## Normal Matrix

Any matrix that is not Upper, Lower or Diagonal.

```
5 3 2
4 8 1
7 6 9
```

---

# 📡 Communication Flow

```
+-----------+                     +-----------+
|  Client   |                     |  Server   |
+-----------+                     +-----------+
      |                                 |
      |------ Connect ----------------->|
      |                                 |
      |------ Send Matrix ------------->|
      |                                 |
      |        Check Matrix Type        |
      |                                 |
      |<----- Send Result --------------|
      |                                 |
      |------ Close Connection -------->|
```

---

# 💻 Compilation

Compile both Java files.

```bash
javac Server.java
javac Client.java
```

---

# ▶️ Execution

## Terminal 1

```bash
java Server
```

Output

```
Server waiting for connection...
```

---

## Terminal 2

```bash
java Client
```

Example

```
Enter order of matrix : 3

Generated Matrix

18 13 35
5 47 38
32 23 29

Matrix Type : Normal Matrix
```

---

# 📸 Sample Server Output

```
Server waiting for connection...

Client Connected.

Received Matrix

18 13 35
5 47 38
32 23 29

Matrix Type : Normal Matrix
```

---

# 🧠 Code Explanation

## Client.java

- Creates a TCP socket.
- Connects to the server.
- Reads matrix order.
- Generates random matrix values.
- Randomly converts the matrix into one of four matrix types.
- Sends matrix using **ObjectOutputStream**.
- Receives result using **DataInputStream**.
- Displays the matrix type.

---

## Server.java

- Creates a **ServerSocket**.
- Accepts incoming client requests.
- Receives matrix using **ObjectInputStream**.
- Checks whether the matrix is:
  - Upper Triangular
  - Lower Triangular
  - Diagonal
  - Normal
- Sends the identified type back using **DataOutputStream**.

---

# 📚 Concepts Used

- TCP Protocol
- Client–Server Architecture
- Socket Programming
- Java Streams
- Object Serialization
- Matrix Operations
- Nested Loops
- Conditional Statements
- Random Number Generation

---

# 🎓 Viva Questions

### What is TCP?

TCP is a reliable, connection-oriented transport layer protocol.

---

### Why TCP instead of UDP?

TCP guarantees reliable and ordered delivery of data.

---

### What is Socket?

A Socket is one endpoint of communication between two devices.

---

### What is ServerSocket?

ServerSocket waits for incoming client connections.

---

### What is localhost?

localhost refers to the local computer (127.0.0.1).

---

### Why use port 9002?

Port number identifies the communication endpoint between client and server.

---

### Why ObjectOutputStream?

To send Java objects like a two-dimensional array.

---

### Why DataInputStream?

To receive primitive data types and strings.

---

### What is an Upper Triangular Matrix?

All elements below the main diagonal are zero.

---

### What is a Lower Triangular Matrix?

All elements above the main diagonal are zero.

---

### What is a Diagonal Matrix?

Only diagonal elements are non-zero.

---

### Why close sockets?

To release resources and terminate the connection properly.

---

# 🚀 Future Enhancements

- Multiple client support
- GUI using Java Swing/JavaFX
- Matrix operations (Addition, Multiplication, Transpose)
- Multithreaded server
- Chat-based client-server communication
- File transfer using TCP

---

# 📌 Learning Outcomes

- Understanding TCP communication
- Java Socket Programming
- Object Serialization
- Client–Server Architecture
- Matrix Processing
- Network Programming Fundamentals

---

# ✅ Result

The TCP Client–Server application was successfully implemented using Java Socket Programming. The client generated a random matrix, transmitted it to the server, and the server correctly identified whether it was an **Upper Triangular**, **Lower Triangular**, **Diagonal**, or **Normal Matrix** before sending the result back to the client.

---


