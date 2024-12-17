package RMI;

import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.SQLOutput;
import java.util.Base64;

public class RMICharacter486 {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String urlRmi = "rmi://203.162.10.109/RMICharacterService";
        CharacterService service = (CharacterService) Naming.lookup(urlRmi);

        String inputStr = service.requestCharacter("B21DCCN486", "v9Hie5vH");
        System.out.println(inputStr);

        String ans = Base64.getEncoder().encodeToString(inputStr.getBytes());
        service.submitCharacter("B21DCCN486", "v9Hie5vH", ans);
    }
}
