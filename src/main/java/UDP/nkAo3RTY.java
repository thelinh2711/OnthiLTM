package UDP;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class nkAo3RTY {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int serverPort = 2207;
    }

}
