package Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int portNumber = 5555;

        try (
                Socket socket = new Socket(serverAddress, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.print("Enter text to be sent to the server: ");
            String userInput = stdIn.readLine();
            out.println(userInput);

            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
