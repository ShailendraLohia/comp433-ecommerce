package com.example.ecommerce.model.cancel.order;

import javax.persistence.*;

@Entity
@Table(name="return_items")
public class ReturnItems {
    @Id
    private String item_id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="cancelOrderId", nullable = false)
    private OrderCancel orderCancel;

    public ReturnItems(){}

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderCancel getOrderCancel() {
        return orderCancel;
    }

    public void setOrderCancel(OrderCancel orderCancel) {
        this.orderCancel = orderCancel;
    }
}
