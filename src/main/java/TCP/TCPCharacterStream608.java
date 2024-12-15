package TCP;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TCPCharacterStream608 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        dos.write("B21DCCN608;Fg1elzfe");
        dos.newLine();
        dos.flush();

        String s = dis.readLine();
        System.out.println(s);
        String[] a = s.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(a));
        Collections.sort(list);
        String ans = String.join(" ", list);
        dos.write(ans);
        dos.newLine();
        dos.flush();

        socket.close();
    }
}
