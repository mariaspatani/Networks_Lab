import java.net.*;
import java.io.*;
import java.util.*;
public class FileClient{
    public static void main(String[] args)throws Exception{
	 Socket s= new Socket("localhost",5000);
	 System.out.println("Client Thread ID: " + Thread.currentThread().threadId());
	 BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
	 PrintWriter out =new PrintWriter(s.getOutputStream(),true);	 
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the FileName ");
	 out.println(sc.nextLine());
	 String line;
	 while((line=in.readLine())!=null && !line.equals("EOF"))
	 	System.out.println(line);
	 s.close();
    }
}
