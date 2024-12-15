package UDP;

import java.io.IOException;
import java.net.*;
import java.util.TreeMap;

public class UDPString486 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int serverPort = 2208;

        String mess = ";B21DCCN486;A0UKtOpW";
        byte[] messData = mess.getBytes();
        DatagramPacket messPacket = new DatagramPacket(messData, messData.length, serverAddress, serverPort);
        socket.send(messPacket);

        byte[] receiveData = new byte[2024];
        DatagramPacket receivePacket = new DatagramPacket(messData, messData.length);
        socket.receive(receivePacket);

        String a = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(a);
        String[] b = a.split(";");
        String requestId = b[0];
        String c = b[1];
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i=0;i<c.length();i++){
            if(map.containsKey(c.charAt(i))==false){
                map.put(c.charAt(i), 1);
            } else {
                map.put(c.charAt(i), map.get(c.charAt(i))+1);
            }
        }
        int y =1;
        Character x = map.firstKey();
        for (Character i:map.keySet()){
            if(map.get(i)>y){
                x = i;
                y = map.get(i);
            }
        }
        String ans = requestId+ ";"+String.valueOf(x)+ ":";
        for (int i=0;i<c.length();i++){
            if(c.charAt(i)==x){
                ans = ans + String.valueOf(i+1) + ",";
            }
        }
        System.out.println(ans);

        byte[] ansData = ans.getBytes();
        DatagramPacket ansPacket = new DatagramPacket(ansData, ansData.length, serverAddress, serverPort);
        socket.send(ansPacket);
        socket.close();
    }
}
