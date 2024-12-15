package UDP;

import java.io.IOException;
import java.net.*;

public class UDPDataType486 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int serverPort = 2207;
        String mess = ";B21DCCN486;nkAo3RTY";
        byte[] messData = mess.getBytes();
        DatagramPacket messPacket = new DatagramPacket(messData, messData.length, serverAddress, serverPort);
        socket.send(messPacket);

        byte[] receiveData = new byte[2024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        String a = new String(receivePacket.getData(), 0, receivePacket.getLength());
        String[] b = a.split(";");
        String requestId = b[0];
        String c = b[1];
        int sum = 0;
        for (int i=0;i<c.length();i++){
            sum += Integer.parseInt(String.valueOf(c.charAt(i)));
        }
        String ans = requestId +";"+String.valueOf(sum);
        byte[] ansData = ans.getBytes();
        DatagramPacket ansPacket = new DatagramPacket(ansData, ansData.length, serverAddress, serverPort);
        socket.send(ansPacket);

        socket.close();
    }

}
