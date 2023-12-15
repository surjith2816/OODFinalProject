package com.ecommerce.demo.model;

public class Person {
    
    private Integer id;
    private String firstName = "";
    private String lastName = "";
    private String userName = "";
    private String password = "";
    private String email = "";
    private String phNo = "";
    private String personRole = "";
    
    public Person() {
        super();
    }
    
    public Person(Integer id, String firstName, String lastName, String userName, String password, String email, String phNo, String personRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phNo = phNo;
        this.personRole = personRole;
    }
    
    public String getPersonRole() {
        return personRole;
    }
    
    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhNo() {
        return phNo;
    }
    
    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", email=" + email + ", phNo=" + phNo + ", personRole=" + personRole + '}';
    }
    
}
