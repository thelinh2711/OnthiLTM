/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package WSClient;

import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

public class WSDataService486 {
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        
        List<Integer> list = ds.getData("B21DCCN486", "hKu0Oo8j");
        int sum = 0;
        for(int i:list){
            sum += i;
        }
        
        ds.submitDataInt("B21DCCN486", "hKu0Oo8j", sum);
    }
    
}
