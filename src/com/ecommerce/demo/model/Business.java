package com.ecommerce.demo.model;

import com.ecommerce.demo.controller.ProductController;
import com.ecommerce.demo.controller.PersonController;
import com.ecommerce.demo.controller.OrderController;



public class Business {
    
    private PersonController personDirectory;
    private RetailerInStockProducts retailerInStockProducts;
    private ProductController productDirectory;
    private OrderController orderDirectory;
    
    public Business() {
        this.personDirectory = new PersonController();
        this.retailerInStockProducts = new RetailerInStockProducts();
        this.productDirectory = new ProductController();
        this.orderDirectory = new OrderController();
    }

    public OrderController getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderController orderDirectory) {
        this.orderDirectory = orderDirectory;
    }
    
    public ProductController getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ProductController productDirectory) {
        this.productDirectory = productDirectory;
    }
    
    public RetailerInStockProducts getRetailerInStockProducts() {
        return retailerInStockProducts;
    }

    public void setRetailerInStockProducts(RetailerInStockProducts retailerInStockProducts) {
        this.retailerInStockProducts = retailerInStockProducts;
    }
    
    public PersonController getPersonDirectory() {
        return personDirectory;
    }
    
    public void setPersonDirectory(PersonController personDirectory) {
        this.personDirectory = personDirectory;
    }

    @Override
    public String toString() {
        return "Business{" + "personDirectory=" + personDirectory + ", retailerInStockProducts=" + retailerInStockProducts + ", productDirectory=" + productDirectory + ", orderDirectory=" + orderDirectory + '}';
    }
    
}
