package Lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Alp_dig_Sym_Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter text: ");
            String text = userInput.readLine();
            out.println(text);

            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}