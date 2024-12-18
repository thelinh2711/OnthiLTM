package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class RMIByte306 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ByteService service = (ByteService) registry.lookup("RMIByteService");

        byte[] inputStr = service.requestData("B21DCCN306", "hd1hqYZ2");

        byte[] ans = Base64.getDecoder().decode(inputStr);

        service.submitData("B21DCCN306", "hd1hqYZ2", ans);
    }
}
