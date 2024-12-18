/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSClient;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

/**
 *
 * @author Thế Linh
 */
public class WSObject486 {
    public static void main(String[] args) {
        ObjectService_Service oss = new ObjectService_Service();
        ObjectService os = oss.getObjectServicePort();
        
        vn.medianews.ProductY p = os.requestProductY("B21DCCN486", "SjTFaYgc");
        
        float ans = p.getPrice() * (1 + p.getTaxRate() / 100) * (1 - p.getDiscount() / 100);
        p.setFinalPrice(ans);
        
        os.submitProductY("B21DCCN486", "SjTFaYgc", p);
    }
}
