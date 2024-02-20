package Lab4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Server is running...");

            while (true) {
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                socket.receive(receivePacket);

                String request = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int n = Integer.parseInt(request);

                // Calculate the nth term of the Fibonacci series
                long nthTerm = calculateNthFibonacci(n);

                // Convert the result to bytes and send it back to the client
                byte[] sendBuffer = String.valueOf(nthTerm).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long calculateNthFibonacci(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long temp = b;
                b = a + b;
                a = temp;
            }
            return a;
        }
    }
}