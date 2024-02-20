package Lab4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Alp_dig_Sym_Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server listening on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String text = in.readLine();
                int[] counts = countChars(text);
                out.println("Alphabets: " + counts[0] + ", Digits: " + counts[1] + ", Symbols: " + counts[2]);

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] countChars(String text) {
        int alphabetCount = 0;
        int digitCount = 0;
        int symbolCount = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabetCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                symbolCount++;
            }
        }

        return new int[] { alphabetCount, digitCount, symbolCount };
    }
}