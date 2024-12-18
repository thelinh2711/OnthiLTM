package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udpDatatype306 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int serverPort = 2207;

        String mess = ";B21DCCN306;t8WLgMjw";
        byte[] messData = mess.getBytes();
        DatagramPacket messPacket = new DatagramPacket(messData, messData.length, serverAddress, serverPort);
        socket.send(messPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String a = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(a);
        String[] s = a.split(";");
        String reqId = s[0];
        String strEncode = s[1];
        int n = Integer.parseInt(s[2]);
        String ans = "";
        for(char i:strEncode.toCharArray()){
            if(Character.isUpperCase(i)){
                ans += (char) ((i-'A'+n+26)%26 + 'A');

            }
            if(Character.isLowerCase(i)){
                ans += (char) ((i-'a'+n+26)%26 + 'a');
            }

        }
        System.out.println(ans);
        String res = reqId + ";" + ans;
        byte[] ansData = res.getBytes();
        DatagramPacket ansPacket = new DatagramPacket(ansData, ansData.length, serverAddress, serverPort);
        socket.send(ansPacket);

        socket.close();

    }
}

