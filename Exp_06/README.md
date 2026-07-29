# 🌐 UDP Client–Server Communication in Java

> **Experiment:** Client–Server communication using UDP. The client sends a sentence
> containing abbreviations (e.g., `idk`, `lol`, `tbh`). The server expands them into
> formal English and sends the translated sentence back.

---

# 📚 Table of Contents

1. Problem Statement
2. Objective
3. Theory
4. Architecture
5. Algorithm
6. Project Structure
7. Client Working
8. Server Working
9. Important Java Classes
10. Sample Input / Output
11. TCP vs UDP
12. Viva Questions
13. Future Enhancements
14. Conclusion

---

# 📖 Problem Statement

Develop a UDP Client–Server application in Java. The client accepts a sentence
containing modern English abbreviations and sends it to the server.
The server replaces the abbreviations with their full meanings and sends the
translated sentence back.

---

# 🎯 Objective

- Learn UDP socket programming.
- Understand DatagramSocket and DatagramPacket.
- Implement client–server communication.
- Perform string processing on the server.

---

# 🧠 Theory

**UDP (User Datagram Protocol)** is a connectionless transport layer protocol.

### Advantages
- Fast
- Low overhead
- Suitable for streaming, VoIP, gaming and DNS

### Disadvantages
- No acknowledgement
- No retransmission
- No guaranteed delivery

---

# 🏗 Architecture

```text
Client
   │
Enter Sentence
   │
Convert to Bytes
   │
DatagramPacket
   │
──────────── UDP ───────────►
                     Server
               Receive Packet
               Replace Words
               Convert to Bytes
◄──────────── UDP ───────────
   │
Display Translation
```

---

# 🔄 Algorithm

## Client

1. Create UDP socket.
2. Read sentence.
3. Convert sentence into bytes.
4. Create DatagramPacket.
5. Send packet.
6. Receive translated packet.
7. Display translated sentence.
8. Close socket.

## Server

1. Create DatagramSocket on port 9002.
2. Wait for client.
3. Receive packet.
4. Convert bytes into String.
5. Replace abbreviations.
6. Convert String into bytes.
7. Send translated packet.
8. Close socket.

---

# 📂 Project Structure

```
UDP-Abbreviation-Translator
│
├── Client.java
├── Server.java
└── README.md
```

---

# 💻 Client Working

- Creates UDP socket.
- Reads input from keyboard.
- Converts String into byte array.
- Sends packet to server.
- Waits for reply.
- Displays translated sentence.
- Closes socket.

---

# 🖥 Server Working

- Creates socket on port 9002.
- Waits for client packet.
- Receives sentence.
- Replaces abbreviations using replace().
- Sends translated sentence.
- Closes socket.

---

# 📚 Important Java Classes

| Class | Purpose |
|------|---------|
| DatagramSocket | Creates UDP socket |
| DatagramPacket | Stores UDP packet |
| InetAddress | Gets IP Address |
| Scanner | Reads keyboard input |

---

# 📊 Sample Input

```
Really idk about this atm lol
```

# 📊 Sample Output

```
Really I don't know about this at the moment laugh out loud
```

---

# ⚖ TCP vs UDP

| TCP | UDP |
|------|------|
| Connection-oriented | Connectionless |
| Reliable | Unreliable |
| Slower | Faster |
| Acknowledgement | No acknowledgement |

---

# 🎤 Viva Questions

### 1. What is UDP?
UDP is a connectionless transport layer protocol.

### 2. Why is UDP faster than TCP?
It does not establish a connection or use acknowledgements.

### 3. Which class creates a UDP socket?
DatagramSocket.

### 4. Which class stores UDP data?
DatagramPacket.

### 5. Why use getBytes()?
To convert a String into a byte array.

### 6. Why use new String()?
To convert bytes into a readable String.

### 7. What is localhost?
127.0.0.1 (same computer).

### 8. Which port is used?
9002.

### 9. What does send() do?
Sends a UDP packet.

### 10. What does receive() do?
Receives a UDP packet.

### 11. Can UDP lose packets?
Yes.

### 12. Does UDP guarantee delivery?
No.

### 13. Real-world applications?
DNS, VoIP, live streaming, gaming.

### 14. Why is DatagramPacket required?
It contains data, destination IP and port.

### 15. Difference between TCP and UDP?
TCP is reliable; UDP is faster but unreliable.

---

# 🚀 Future Enhancements

- GUI using Java Swing
- Multiple client support
- Database of abbreviations
- Case-insensitive translation

---

# 📌 Conclusion

This experiment demonstrates UDP client–server communication using Java.
The client sends a sentence containing abbreviations, and the server translates
them into formal English before returning the result. The program helps in
understanding socket programming, packet transmission and basic string
manipulation.
