import java.io.*;
import java.net.*;
import java.util.*;
public class MatrixClient{
  public static void main(String[] args)throws Exception{
    Socket s=new Socket("localhost",5000);
    BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out =new PrintWriter(s.getOutputStream(),true);
    Scanner sc =new Scanner(System.in);
    Random r =new Random();
    System.out.println("Enter N: ");
    int n= sc.nextInt();
    out.println(n);
    int [][]a=new int[n][n];
    System.out.println("\nMatrix: ");
    for (int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        a[i][j]=r.nextInt(50)+1;
        System.out.printf("%4d",a[i][j]);
      }
      System.out.println();
    }
    
    for(int i = 0; i < n; i++){
       for(int j = 0; j < n; j++)
         out.print(a[i][j] + " ");
       out.println();
   }
    System.out.println(in.readLine());
    s.close();
    }
  }
