package com.ecommerce.demo.model;

import com.ecommerce.demo.controller.ProductController;
import com.ecommerce.demo.controller.PersonController;
import com.ecommerce.demo.controller.ProductController.Product;
import java.util.*;

public class ConfigureBusiness {
    
    private Business business;
    private PersonController personDirectory;
    private RetailerInStockProducts retailerInStockProducts;
    private ProductController productDirectory;
    
    public ConfigureBusiness() {
        this.business = new Business();
        this.personDirectory = new PersonController();
        this.retailerInStockProducts = new RetailerInStockProducts();
        this.productDirectory = new ProductController();
    }
    
    public Business configureBusinessData() {
        Person person_01 = new Person(1,"retailer","1","retailer","ret","retailer@gmail.com","+1-(865)-283-2019","Retailer");
        Person person_02 = new Person(2,"customer","1","customer1","cust1","customer1@gmail.com","+1-(283)-293-9283","Customer");
        Person person_03 = new Person(3,"logistics","1","logistics1","log1","logistics1@gmail.com","+1-(283)-293-2836","Logistics");
        Person person_04 = new Person(4,"logistics","2","logistics2","log2","logistics2@gmail.com","+1-(223)-245-2941","Logistics");
        this.personDirectory.addNewPerson(person_01);
        this.personDirectory.addNewPerson(person_02);
        this.personDirectory.addNewPerson(person_03);
        this.personDirectory.addNewPerson(person_04);
        
        
        this.retailerInStockProducts.addStockDetailsfromCSV("src/CSVFiles/StockDetails.csv");
        
        
        this.productDirectory.addProductListfromCSV("src/CSVFiles/Products.csv");
        
        this.business.setPersonDirectory(this.personDirectory);
        this.business.setRetailerInStockProducts(this.retailerInStockProducts);
        this.business.setProductDirectory(this.productDirectory);
        
        return this.business;
    }
    
}
