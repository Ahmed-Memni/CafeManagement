package com.cafe.models;

import java.util.Objects;
import java.util.Scanner;

public final class OrderItem {
    private final String name;
    private final double price;

    public OrderItem( String name, int quantity, double price) {
        this.name = name;
        this.price = price;
    }
    public OrderItem() {
        this.name = "a";

        this.price = 1;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same reference
        if (o == null || getClass() != o.getClass()) return false; // Null or different type
        OrderItem orderItem = (OrderItem) o;
        return Double.compare(orderItem.price, price) == 0 && Objects.equals(name, orderItem.name);
    }
}
