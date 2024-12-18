package com.cafe.models;

import java.util.List;

public final class Order {
    private final String orderId;
    private final List<OrderItem> items;
    private final Customer customer;
    private final Server server;
    private double totalCost;

    public Order(String orderId, List<OrderItem> items, Customer customer, Server server, double totalCost) {
        this.orderId = orderId;
        this.items = items;
        this.customer = customer;
        this.server = server;
        this.totalCost = totalCost;
    }
    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Server getServer() {
        return server;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
