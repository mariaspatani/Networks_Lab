import java.util.*;
import java.io.*;
import java.net.*;
public class UDPServer{
  public static void main(String[] args)throws Exception{
    DatagramSocket ds=new DatagramSocket(9876);
    System.out.println("Server Started...");
    
    while (true){
      byte[] buf =new byte[100];
      DatagramPacket dp=new DatagramPacket(buf,buf.length);
      ds.receive(dp);
      
      String msg=new String(dp.getData(),0,dp.getLength());
      System.out.println("Received: " + msg);
      msg = msg.replace("tbh", "to be honest").replace("ig", "I guess")
                     .replace("tbf", "to be fair").replace("atm", "at the moment")
                     .replace("irl", "in real life").replace("lol", "laughing out loud")
                     .replace("asap", "as soon as possible").replace("omg", "oh my God")
                     .replace("ttyl", "talk to you later").replace("idk", "I don't know")
                     .replace("nvm", "never mind").replace("idc", "I don't care");
      
      byte[] data=msg.getBytes();
      DatagramPacket reply=new DatagramPacket(data,data.length,dp.getAddress(),dp.getPort());
      ds.send(reply);
      System.out.println("Translation sent");
    } 
    }
  }
