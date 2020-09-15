package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> li;

    public Order(String nm, String addr, List<LineItem> li) {
        this.customerName = nm;
        this.address = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return li;
    }
}
