package com.ecommerce.demo.controller;

import java.util.*;
import com.ecommerce.demo.utils.FileUtil;

public class ProductController {
    
    private ArrayList<Product> productList;
    
    public ProductController() {
        this.productList = new ArrayList<Product>();
    }
    
    public ProductController(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
    public void addProductListfromCSV(String filepath) {
        try {
	            FileUtil obj = new FileUtil();
	            List<String> csvLines = obj.readFile(filepath);
	            for (String line : csvLines) {
	                productList.add(new Product(line));
	            }
	        } catch (Exception e) {
	            System.out.println("Exception: " + e);
	        }
    }
    
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    
        public void addNewProduct(Product product) {
        productList.add(product);
        System.out.println(productList);
    }
    
    public void removeProduct(String productName) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(productName)) {
                iterator.remove();
                break;
            }
        }
    }
    
    public Product findProduct(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    
    public int totalProducts() {
        return this.productList.size();
    }
    
    public ArrayList<String> getProductNames() {
        ArrayList<String> productNames = new ArrayList<>();
        for (Product product : productList) {
            productNames.add(product.getProductName());
        }
        return productNames;
    }
    
    
    @Override
    public String toString() {
        return "ProductCatalog{" + "productList=" + productList + '}';
    }
    
    
    public static class Product {
        private int productId;
        private String productName;
        private String description;
        private String sellingPrice;
        
        public Product() {
        }
         public Product(String csvline){
        String[] csvarray = csvline.split(",");
        this.productId = Integer.parseInt(csvarray[0]);
        this.productName = csvarray[1];
        this.description = csvarray[2];
        this.sellingPrice = csvarray[3];
        }
        public Product(int productId, String productName, String description, String sellingPrice) {
            this.productId = productId;
            this.productName = productName;
            this.description = description;
            this.sellingPrice = sellingPrice;
        }
        
        public int getProductId() {
            return productId;
        }
        
        public void setProductId(int productId) {
            this.productId = productId;
        }
        
        public String getProductName() {
            return productName;
        }
        
        public void setProductName(String productName) {
            this.productName = productName;
        }
        
        public String getDescription() {
            return description;
        }
        
        public void setDescription(String description) {
            this.description = description;
        }
        
        public String getSellingPrice() {
            return sellingPrice;
        }
        
        public void setSellingPrice(String sellingPrice) {
            this.sellingPrice = sellingPrice;
        }
        
        @Override
        public String toString() {
            return "Product{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", sellingPrice=" + sellingPrice + '}';
        }
    }
}
