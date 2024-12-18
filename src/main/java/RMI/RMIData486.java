package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class RMIData486 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        DataService service = (DataService) registry.lookup("RMIDataService");

        Integer a = (Integer) service.requestData("B21DCCN486", "QLBa0cEj");

        int[] coins = {10, 5, 2, 1};
        int dem = 0;
        List<Integer> list = new ArrayList<>();
        for (int i:coins){
            while (a>=i){
                a = a-i;
                dem++;
                list.add(i);
            }
        }
        if(a>0){
            service.submitData("B21DCCN486", "QLBa0cEj", "-1");
        } else {
            String ans = String.valueOf(dem)+"; ";
            for (int i=0;i<list.size()-1;i++){
                ans += String.valueOf(list.get(i))+",";
            }
            ans += String.valueOf(list.get(list.size()-1));
            service.submitData("B21DCCN486", "QLBa0cEj", ans);
        }
    }
}
