package Lab4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the value of 'n' to get the nth term of the Fibonacci series: ");
            int n = scanner.nextInt();
            String request = String.valueOf(n);
            byte[] sendBuffer = request.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, PORT);
            socket.send(sendPacket);

            // Receive the nth term of the Fibonacci series from the server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("The " + n + "th term of the Fibonacci series is: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}