package TCP;

import java.io.*;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

public class zGOmXuWO {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        dos.write("B21DCCN486;zGOmXuWO");
        dos.flush();
        dos.newLine();

        String s = dis.readLine();
        System.out.println(s);
        Set<Character> set = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)>='a'&&s.charAt(i)<='z' || s.charAt(i)>='A'&&s.charAt(i)<='Z') {
                set.add(s.charAt(i));
            }
        }
        String ans ="";
        for (Character i:set){
            ans += String.valueOf(i);
        }
        System.out.println(ans);
        dos.write(ans);
        dos.flush();
        dos.newLine();

        socket.close();
    }
}
