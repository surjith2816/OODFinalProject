package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Order;
import java.util.ArrayList;

public class OrderController {
    
    private ArrayList<Order> orderList;
    
    public OrderController() {
        this.orderList = new ArrayList<Order>();
    }
    
    public OrderController(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    
    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    public void addNewOrder(Order order) {
        this.orderList.add(order);
    }
    
    public void removeOrder(int orderId) {
        Order orderToRemove = findByOrderId(orderId);
        if (orderToRemove != null) {
            orderList.remove(orderToRemove);
        }
    }
    
    public Order findByOrderId(int orderId) {
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
    
    public ArrayList<Order> getOrdersByUsername(String username) {
        ArrayList<Order> userOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUserName().equals(username)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
    
    public ArrayList<Order> getOrdersByStatus(String status) {
        ArrayList<Order> statusOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getStatus().equals(status)) {
                statusOrders.add(order);
            }
        }
        return statusOrders;
    }
    
    public ArrayList<Order> getOrdersByDeliveryPerson(String deliveryPersonName) {
        ArrayList<Order> deliveryPersonOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getDeliveryPerson().equals(deliveryPersonName)) {
                deliveryPersonOrders.add(order);
            }
        }
        return deliveryPersonOrders;
    }
    
    
    
    @Override
    public String toString() {
        return "OrderDirectory{" + "orderList=" + orderList + '}';
    }
    
}
