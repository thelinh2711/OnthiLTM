package RMI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;

public class RMIData306 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        DataService service = (DataService) registry.lookup("RMIDataService");

        String data = (String) service.requestData("B21DCCN306", "BIsKIvtI");
        System.out.println(data);
        String[] parts = data.toString().trim().split(";");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1].trim());

        List<Integer> ans = new ArrayList<>();
        for(int i=n;i<k;i++){
            if(ktra(i)) ans.add(i);
        }

        service.submitData("B21DCCN486", "BIsKIvtI", ans);

    }
    public static boolean ktra(int x){
        String s = String.valueOf(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
