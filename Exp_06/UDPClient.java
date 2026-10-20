import java.util.*;
import java.io.*;
import java.net.*;
public class UDPClient{
  public static void main(String[] args)throws Exception{
    DatagramSocket ds =new DatagramSocket();
    Scanner sc = new Scanner(System.in);
    InetAddress ip =InetAddress.getByName("localhost");
    System.out.println("Enter the Sentence: ");
    byte[] data=sc.nextLine().getBytes();
    DatagramPacket dp=new DatagramPacket(data,data.length,ip,9876);
    ds.send(dp);
    
    data=new byte[1024];
    dp=new DatagramPacket(data,data.length);
    ds.receive(dp);
    
    System.out.println("Translated Msg: "+ new String(dp.getData(),0,dp.getLength()));
    ds.close();
    sc.close();
    }
  }
