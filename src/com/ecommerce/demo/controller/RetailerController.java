package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Retailer;
import java.util.ArrayList;

public class RetailerController {
    
    private ArrayList<Retailer> retailerList;
    
    public RetailerController() {
        this.retailerList = new ArrayList<Retailer>();
    }
    
    public RetailerController(ArrayList<Retailer> retailerList) {
        this.retailerList = retailerList;
    }
    
    public ArrayList<Retailer> getRetailerList() {
        return retailerList;
    }
    
    public void setRetailerList(ArrayList<Retailer> retailerList) {
        this.retailerList = retailerList;
    }
    
    public void addNewRetailer(Retailer retailer) {
        this.retailerList.add(retailer);
    }
    
    public void removeRetailer(Retailer retailer) {
        this.retailerList.remove(retailer);
    }
    
    public boolean isRetailerUserValid(String username, String password) {
        for (Retailer retailer : this.retailerList) {
            if (retailer.getUserName().equals(username) && retailer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "RetailerDirectory{" + "retailerList=" + retailerList + '}';
    }
    
}
