package Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Source_Code_Webpage {

    public static void main(String[] args) {
        try {
            // Get the URL from the user
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the URL of the webpage you want to read: ");
            String urlString = userInputReader.readLine();

            // Specify the URL of the webpage
            URL url = new URL(urlString);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Create a BufferedReader to read the webpage content
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            if (e.getMessage().contains("Server returned HTTP response code: 403")) {
                System.out.println("Error: Access Forbidden. Check your permissions or credentials.");
            } else {
                // Handle other IOExceptions
                e.printStackTrace();
            }
        }
    }
}