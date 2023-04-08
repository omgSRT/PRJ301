/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangND.Cart;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author omg
 */
public class CartObj implements Serializable{
    private String customerID;
    private Map<String, Integer> items;

    public CartObj() {
    }

    public CartObj(String customerID, Map<String, Integer> items) {
        this.customerID = customerID;
        this.items = items;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartObj{" + "customerID=" + customerID + ", items=" + items + '}';
    }
    
    public void addItemToCart(String title){
        if(items == null){
            items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if(this.items.containsKey(title)){
            quantity = this.items.get(title) + 1;
        }
        this.items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title){
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(title)){
            this.items.remove(title);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
