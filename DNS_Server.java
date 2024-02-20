package Lab4;
import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class DNS_Server {

    private static Hashtable<String, String> dnsTable = new Hashtable<>();
    private static Hashtable<String, Integer> visitCount = new Hashtable<>();

    public static void main(String[] args) {
        int port = 8086;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("DNS Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String clientRequest = in.readLine();
            System.out.println("Received request from client: " + clientRequest);

            // Check if the URL is present in the DNS table
            if (dnsTable.containsKey(clientRequest)) {
                String ipAddress = dnsTable.get(clientRequest);
                int count = visitCount.getOrDefault(clientRequest, 0) + 1;
                visitCount.put(clientRequest, count);
                out.println("IP Address: " + ipAddress + ", Visited Count: " + count);
            } else {
                // If the URL is not present, simulate DNS lookup and store in the table
                String ipAddress = simulateDNSLookup(clientRequest);
                dnsTable.put(clientRequest, ipAddress);
                visitCount.put(clientRequest, 1);
                out.println("IP Address: " + ipAddress + ", Visited Count: 1");
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String simulateDNSLookup(String url) {
        return "192.168.1.1";
    }
}
