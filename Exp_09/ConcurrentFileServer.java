import java.io.*;
import java.net.*;

public class ConcurrentFileServer{
  public static void main(String[] args) throws Exception{
    ServerSocket ss = new ServerSocket(5000);
    long pid = ProcessHandle.current().pid();
    
    System.out.println("Concurrent File Server Started...");
    System.out.println("Server PID: " + pid);
    System.out.println("Listening on port 5000");
    
    while(true){
      Socket s =ss.accept();
      
      new Thread(()->{
        try{
          BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
          
          PrintWriter out=new PrintWriter(s.getOutputStream(),true);
          
          String name =in.readLine();
          
          System.out.println("Requested file :" +name);
          out.println("Server :"+pid);
          
          File f=new File(name);
          if(f.exists() && f.isFile()){
            out.println("File Found");
            
           BufferedReader fr = new BufferedReader(new FileReader(f));
            String Line;
            while((Line=fr.readLine())!=null){
              out.println(Line);
            }
          }else{
            out.println("File Not Found");
            
          }
          out.println("EOF");

                    
          s.close();
        }catch(Exception e){
          System.out.println("Error: " + e.getMessage());
        }
      
      }).start();
    
    }
    
 } 
}
