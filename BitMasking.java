package Lab1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BitMasking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            byte[] ipAddressBytes = inetAddress.getAddress();

            // Classify the IP address based on each octet
            char ipClass = classifyIPAddress(ipAddressBytes);

            System.out.println("IP Address: " + ipAddress);
            System.out.println("Class: " + ipClass);
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address");
        } finally {
            scanner.close();
        }
    }

    private static char classifyIPAddress(byte[] ipAddressBytes) {
        // Classify based on the first octet
        int firstOctet = ipAddressBytes[0] & 0xFF;
        if ((firstOctet & 0b10000000) == 0) {
            return 'A';
        } else if ((firstOctet & 0b11000000) == 0b10000000) {
            return 'B';
        } else if ((firstOctet & 0b11100000) == 0b11000000) {
            return 'C';
        } else if ((firstOctet & 0b11110000) == 0b11100000) {
            return 'D';
        } else {
            return 'E';
        }
    }
}