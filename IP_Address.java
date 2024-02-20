package Lab1;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP_Address {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost=InetAddress.getLocalHost();
        System.out.println("System ip address:"+localhost.toString());
        System.out.println("System Name is:"+localhost.getHostName());
    }
}