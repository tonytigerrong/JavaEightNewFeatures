package com.eight.stream;


public class Tool {
    String type;
    double price;

    public Tool(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}