package com.ecommerce.demo.model;

import com.ecommerce.demo.controller.ProductController;
import com.ecommerce.demo.utils.FileUtil;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;

public class RetailerInStockProducts {
    
    private HashMap<String, Integer> retailerInStockProducts;
    
    public RetailerInStockProducts() {
        this.retailerInStockProducts = new HashMap<String, Integer>();
    }
    
    public RetailerInStockProducts(HashMap<String, Integer> inStockProducts) {
        this.retailerInStockProducts = inStockProducts;
    }
    
    public HashMap<String, Integer> getRetailerInStockProducts() {
        return retailerInStockProducts;
    }
    
    public void setRetailerInStockProducts(HashMap<String, Integer> retailerInStockProducts) {
        this.retailerInStockProducts = retailerInStockProducts;
    }
    
    public void addProducts(String productName, int count) {
        if (retailerInStockProducts.containsKey(productName)) {
            int currentCount = retailerInStockProducts.get(productName);
            retailerInStockProducts.put(productName, currentCount + count);
        } else {
            retailerInStockProducts.put(productName, count);
        }
    }
    
    public void addStockDetailsfromCSV(String filepath) {
        try {
	            FileUtil obj = new FileUtil();
	            List<String> csvLines = obj.readFile(filepath);
	            for (String line : csvLines) {
                        String[] r = line.split(",");
	                addProducts(r[0],Integer.parseInt(r[1]));
	            }
	        } catch (Exception e) {
	            System.out.println("Exception: " + e);
	        }
    }
    
    public void removeProducts(String productName, int count) {
        if (retailerInStockProducts.containsKey(productName)) {
            int currentCount = retailerInStockProducts.get(productName);
            if (currentCount <= count) {
                retailerInStockProducts.remove(productName);
            } else {
                retailerInStockProducts.put(productName, currentCount - count);
            }
        }
    }
    
    public Set<Map.Entry<String, Integer>> getProducts() {
        return retailerInStockProducts.entrySet();
    }
    
    public boolean isOrderPossible(HashMap<String, Integer> orderItems) {
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String productName = entry.getKey();
            int orderQuantity = entry.getValue();
            if (retailerInStockProducts.containsKey(productName)) {
                int availableQuantity = retailerInStockProducts.get(productName);
                if (orderQuantity > availableQuantity) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    public void processOrder(HashMap<String, Integer> orderItems) {
        if (isOrderPossible(orderItems)) {
            for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
                String productName = entry.getKey();
                int orderQuantity = entry.getValue();
                int availableQuantity = retailerInStockProducts.get(productName);
                retailerInStockProducts.put(productName, availableQuantity - orderQuantity);
            }
            System.out.println("Order processed successfully!");
        } else {
            System.out.println("Order cannot be processed due to insufficient stock.");
        }
    }
    
    @Override
    public String toString() {
        return "InStockProducts{" + "inStockProducts=" + retailerInStockProducts + '}';
    }
    
}
