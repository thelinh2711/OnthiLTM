package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class RMIByte486 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");

        byte[] data = byteService.requestData("B21DCCN486", "QfgN6VtP");

        int n = data.length;
        byte[] ans = new byte[n];

        for (int i=0;i<n;i++){
            ans[i] = (byte) (data[i]+n);
        }

        byteService.submitData("B21DCCN486", "QfgN6VtP", ans);
    }
}
