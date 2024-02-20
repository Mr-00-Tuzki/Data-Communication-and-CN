package Lab1;
import java.net.*;
import java.util.Enumeration;

public class Network_Interfaces {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                System.out.println("Interface Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());

                // Get the IP addresses associated with this network interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("  IP Address: " + inetAddress.getHostAddress());
                }

                System.out.println("---------------------------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}