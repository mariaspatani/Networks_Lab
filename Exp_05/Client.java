import java.net.*;
import java.io.*;
import java.util.*;

class MatrixClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        out.println(n);
        System.out.println("Matrix:");

        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                a[i][j] = r.nextInt(50) + 1;
                System.out.print(a[i][j] + " ");
                row += a[i][j] + (j == n - 1 ? "" : " ");
            }
            System.out.println();
            out.println(row);
        }

        System.out.println("Result: " + in.readLine());
        s.close();
        sc.close();
    }
}
