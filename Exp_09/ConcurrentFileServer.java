import java.net.*;
import java.io.*;
import java.util.*;
public class ConcurrentServer{
  public static void main(String[] args)throws Exception{
    ServerSocket ss= new ServerSocket(5000);
    long pid =ProcessHandle.current().pid();
    System.out.println("Server Started..."+pid);
    while (true){
      Socket s= ss.accept();
      System.out.println("Client IP: " + s.getInetAddress());
      System.out.println("Client Port: " + s.getPort());
      new Thread(()->{
        try{
          BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
          PrintWriter out =new PrintWriter(s.getOutputStream(),true);
          String name =in.readLine();
          System.out.println("Requested File "+name);
          out.println("Server PID "+ pid);
          
          File f= new File(name);
          if(f.exists() && f.isFile()){
            out.println("File Found ");        
            BufferedReader fr =new BufferedReader(new FileReader(f));
            String line;
            while((line=fr.readLine())!=null)
              out.println(line);
              fr.close();
          }else{
            out.println("File Not Found");
          }
          
          out.println("EOF");
          s.close();
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }).start();
    }
  }
}
