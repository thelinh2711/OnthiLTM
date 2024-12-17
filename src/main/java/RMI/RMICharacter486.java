package RMI;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class RMICharacter486 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService service = (CharacterService) registry.lookup("RMICharacterService");

        String inputStr = service.requestCharacter("B21DCCN486", "v9Hie5vH");
        System.out.println(inputStr);

        String ans = Base64.getEncoder().encodeToString(inputStr.getBytes());
        service.submitCharacter("B21DCCN486", "v9Hie5vH", ans);
    }
}
