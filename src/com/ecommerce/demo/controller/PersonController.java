package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Person;
import java.util.ArrayList;

public class PersonController {
    
    private ArrayList<Person> personList;
    
    public PersonController() {
        this.personList = new ArrayList<Person>();
    }
    
    public PersonController(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public void addNewPerson(Person person) {
        this.personList.add(person);
    }
    
    public void removePerson(Person person) {
        this.personList.remove(person);
    }
    
    public boolean isValidUser(String userName, String password) {
        for (Person person : personList) {
            if (person.getUserName().equals(userName) && person.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public String getUserRole(String userName, String password) {
        for (Person person : personList) {
            if (person.getUserName().equals(userName) && person.getPassword().equals(password)) {
                return person.getPersonRole();
            }
        }
        return "";
    }
    
     public boolean isUsernameUnique(String userName) {
        for (Person person : personList) {
            if (person.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "PersonDirectory{" + "personList=" + personList + '}';
    }
    
}
