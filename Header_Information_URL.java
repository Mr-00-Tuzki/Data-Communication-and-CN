package Lab2;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.List;

public class Header_Information_URL {

    public static void main(String[] args) {
        try {
            // Get the URL from the user
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter the URL: ");
            String urlString = scanner.nextLine();

            // Specify the URL
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Get the header fields from the URL connection
            Map<String, List<String>> headers = urlConnection.getHeaderFields();

            // Print the header information
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                if (key == null) {
                    // The key is null for the status line, so print it separately
                    System.out.println("Status Line: " + values.get(0));
                } else {
                    System.out.println(key + ": " + String.join(", ", values));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
