package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_2_Server {
    public static void main(String[] args) {
        int portNumber = 5556;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server listening on port " + portNumber);

            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    // Receive two numbers from the client
                    int num1 = Integer.parseInt(in.readLine());
                    int num2 = Integer.parseInt(in.readLine());

                    // Calculate the GCD
                    int gcd = calculateGCD(num1, num2);

                    // Send the GCD back to the client
                    out.println(gcd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
