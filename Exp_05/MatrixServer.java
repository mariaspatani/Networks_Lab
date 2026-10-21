import java.io.*;
import java.net.*;
import java.util.*;
public class MatrixServer{
  public static void main(String[] args)throws Exception{
    ServerSocket ss=new ServerSocket(5000);
    System.out.println("Server Started...");
    System.out.println("Listening on the Port 5000: ");
    while(true){
      Socket s= ss.accept();
      BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintWriter out =new PrintWriter(s.getOutputStream(),true);
      int n= Integer.parseInt(in.readLine());
      int [][]a=new int[n][n];
      System.out.println("\nGenerated Matrix: ");
      for (int i=0;i<n;i++){
        String[] row = in.readLine().trim().split("\\s+");
        for(int j=0;j<n;j++){
          a[i][j]=Integer.parseInt(row[j]);
          System.out.printf("%4d",a[i][j]);
        }
        System.out.println();
      }
      boolean up=true,low=true,dia=true;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if(i>j &&a[i][j]!=0)up=false;
          if(i<j &&a[i][j]!=0)low=false;
          if(i!=j && a[i][j]!=0)dia=false;
          
        }
      }
       String result =dia?"Diagonal":up?"Upper Traingle":low?"Lower Triangle":"Normal";
       System.out.println("Matrix Type: " + result);
       out.println("Result : "+result);
       s.close();
      }
    }
  }
