package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObject486 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        String mess = "B21DCCN486;ZyLzY6mp";
        oos.writeObject(mess);
        oos.flush();
        System.out.println("gửi thành công");

        Customer c = (Customer) ois.readObject();
        System.out.println("nhân");

        fixUsername(c);
        fixName(c);
        fixNgay(c);

        oos.writeObject(c);
        oos.flush();

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
