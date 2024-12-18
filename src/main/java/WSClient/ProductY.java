/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSClient;

/**
 *
 * @author Thế Linh
 */
public class ProductY {
    private float price, taxRate, discount, finalPrice;

    public ProductY(float price, float taxRate, float discount) {
        this.price = price;
        this.taxRate = taxRate;
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
    
    
}
