package com.ecommerce.demo.model;

import com.ecommerce.demo.controller.ProductController;
import java.util.Map;
import java.util.HashMap;

public class Order {
    
    private int orderId;
    private HashMap<String, Integer> orderItems;
    private String orderPrice;
    private String userName = "";
    private String status = "";
    private String deliveryPerson = "Not Assigned";
    
    public Order() {
        this.orderItems = new HashMap<String, Integer>();
    }

    public Order(int orderId, HashMap<String, Integer> orderItems, String orderPrice, String userName, String status, String deliveryPerson) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.orderPrice = orderPrice;
        this.userName = userName;
        this.status = status;
        this.deliveryPerson = deliveryPerson;
    }
    
    public void deliveryAssigned(String deliveryPerson) {
        setDeliveryPerson(deliveryPerson);
        setStatus("Delivery Assigned");
    }
    
    public void deliveryUnassigned() {
        setDeliveryPerson("Not Assigned");
        setStatus("Order Placed");
    }
    
    public void deliveryPickedUp() {
        setStatus("Delivery Pickedup");
    }
    
    public void deliveryCompleted() {
        setStatus("Delivery Completed");
    }
    
    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public HashMap<String, Integer> getOrderItems() {
        return orderItems;
    }
    
    public void setOrderItems(HashMap<String, Integer> orderItems) {
        this.orderItems = orderItems;
    }
    
    public String getOrderPrice() {
        return orderPrice;
    }
    
    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void calculatePrice(ProductController productDirectory) {
        int totalPrice = 0;
        HashMap<String, Integer> orderItems = getOrderItems();
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            ProductController.Product product = productDirectory.findProduct(productName);
            if (product != null) {
                int price = Integer.parseInt(product.getSellingPrice());
                totalPrice += price * quantity;
            }
        }
        setOrderPrice(String.valueOf(totalPrice));
    }
    
    public int getOrderItemsCount() {
        return orderItems.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderItems=" + orderItems + ", orderPrice=" + orderPrice + ", userName=" + userName + ", status=" + status + ", deliveryPerson=" + deliveryPerson + '}';
    }
    
}
