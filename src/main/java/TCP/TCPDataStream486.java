package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class TCPDataStream486 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        String mess = "B21DCCN486;kZ3aJVjb";
        dos.writeUTF(mess);
        dos.flush();
        System.out.println("gui thanh cong");
        int n = dis.readInt();
        System.out.println(n);
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i=0;i<n;i++){
            int a = dis.readInt();
            if(!mp.containsKey(a)){
                mp.put(a, 1);
            } else {
                mp.put(a, mp.get(a)+1);
            }
        }
        float[] ans = new float[7];
        for (int i=1;i<7;i++){
            float xs = (float) mp.get(i)/n;
            ans[i] = xs;
        }
        for (int i=1;i<7;i++){
            dos.writeFloat(ans[i]);
            dos.flush();
        }

        socket.close();
    }
}
