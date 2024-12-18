package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
public class RMIObject486 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService service = (ObjectService) registry.lookup("RMIObjectService");

        Book b = (Book) service.requestObject("B21DCCN486", "BjMp4F0C");
        String[] tg = b.getAuthor().split(" ");
        String nam = String.valueOf(b.getYearPublished());
        String td = b.getTitle();
        String pa = String.valueOf(b.getPageCount());

        String ans = "";
        ans += tg[0].substring(0, 1).toUpperCase();
        ans += tg[tg.length-1].substring(0, 1).toUpperCase();
        ans += nam.substring(2);
        ans += String.valueOf(td.length());
        ans += pa;
        b.setCode(ans);

        service.submitObject("B21DCCN486", "BjMp4F0C", b);
    }
}