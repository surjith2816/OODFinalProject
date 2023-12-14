package com.ecommerce.demo.model;

import java.util.ArrayList;

public class Retailer extends Person {
    
    private String designation = "";
    
    public Retailer(int id, String firstName, String lastName, String userName, String password, String email, String phNo, String role) {
        super(id, firstName, lastName, userName, password, email, phNo, role);
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
