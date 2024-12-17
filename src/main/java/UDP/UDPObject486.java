package UDP;

import java.io.*;
import java.net.*;

public class UDPObject486 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
        int serverPort = 2209;

        String mess = ";B21DCCN486;qFoW4TAo";
        byte[] messData = mess.getBytes();
        DatagramPacket messPacket = new DatagramPacket(messData, messData.length, serverAddress, serverPort);
        socket.send(messPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] reqIdData = new byte[8];
        DataInputStream dis = new DataInputStream(bais);
        dis.read(reqIdData);
        ObjectInputStream ois = new ObjectInputStream(dis);
        Customer c = (Customer) ois.readObject();

        fixUsername(c);
        fixName(c);
        fixNgay(c);

        DataOutputStream dos = new DataOutputStream(baos);
        dos.write(reqIdData);
        ObjectOutputStream oos = new ObjectOutputStream(dos);
        oos.writeObject(c);

        DatagramPacket ansPacket = new DatagramPacket(baos.toByteArray(), baos.toByteArray().length, serverAddress, serverPort);
        socket.send(ansPacket);
        socket.close();
    }

    public static void fixUsername(Customer c){
        String s = c.getName();
        String[] a = s.split(" ");
        String ans = "";
        for(int i=0;i<a.length-1;i++){
            ans += a[i].toLowerCase().charAt(0);
        }
        ans += a[a.length-1].toLowerCase();
        c.setUserName(ans);
    }
    public static void fixName(Customer c){
        String s = c.getName();
        String[] a = s.split(" ");
        String ans = a[a.length-1].toUpperCase()+",";
        for(int i=0;i<a.length-1;i++){
            ans += " "+a[i].substring(0, 1).toUpperCase()+a[i].substring(1).toLowerCase();
        }
        c.setName(ans);
    }
    public static void fixNgay(Customer c){
        String ngay = c.getDayOfBirth();
        String ans = ngay.substring(3, 5)+'/'+ngay.substring(0, 2)+'/'+ngay.substring(6);
        c.setDayOfBirth(ans);
    }
}

