package TCP;

import java.io.*;
import java.net.Socket;

public class TCPCharacterStream608 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        dos.write("B21DCCN492;IiWePAlo");
        dos.flush();
        dos.newLine();

        String s = dis.readLine();
        System.out.println(s);
    }
}
