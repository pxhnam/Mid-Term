
package Ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Start: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.print("Input n: ");
            int n = scanner.nextInt();
            out.println(n);
            for (int i = 0; i < n; i++) {
                System.out.print("arr[" + i + "]: ");
                out.println(scanner.nextInt());
            }
            System.out.print("Number of element: ");
            out.println(scanner.nextInt());

            System.out.println(in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

