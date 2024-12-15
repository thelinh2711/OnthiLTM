package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPByteStream486 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String mess = "B21DCCN486;7hmAcU8y";
        out.write(mess.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];
        int bytes = in.read(buffer);
        String s = new String(buffer, 0, bytes);

        String a = "";
        String ans = "";
        for(char c:s.toCharArray()){
            if(a.indexOf(c)==-1){
                a += c;
            } else {
                if(ans.length()<a.length()){
                    ans = a;
                }
                a = ""+c;
            }
        }
        String kq = ans + ";"+String.valueOf(ans.length());
        out.write(kq.getBytes());
        out.flush();

        socket.close();
    }
}
