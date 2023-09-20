
package Ex1;

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
            System.out.print("Times: ");
            int i = scanner.nextInt();
            out.println(i);
            scanner.nextLine();
            while (i > 0) {
                System.out.print("Loop " + i + ": ");
                String n = scanner.nextLine();
                out.println(n);
                String res = in.readLine();
                if (res.equals("false")) {
                    System.out.println(res);
                } else {
                    System.out.println(res);
                    i--;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

