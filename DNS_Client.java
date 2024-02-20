package Lab4;
import java.io.*;
import java.net.*;

public class DNS_Client {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8086;

        try (
                Socket socket = new Socket(serverAddress, serverPort);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.print("Enter URL to lookup: ");
            String url = userInput.readLine();
            out.println(url);
            String response = in.readLine();
            System.out.println("Server Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
