package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_2_Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int portNumber = 5556;

        try (
                Socket socket = new Socket(serverAddress, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Get two numbers from the user
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(stdIn.readLine());
            out.println(num1);

            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(stdIn.readLine());
            out.println(num2);

            // Receive the GCD from the server and print it
            int gcd = Integer.parseInt(in.readLine());
            System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
