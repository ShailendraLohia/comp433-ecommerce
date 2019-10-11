package com.example.ecommerce.model.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class Inventory {
    @Id
    private String item_id;
    private String item_category;
    private double item_price;
    private int item_quantity_available;
    private String item_name;
    private String item_description;
    private String item_sold_by;
    private double item_review;

    public Inventory() {

    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public int getItem_quantity_available() {
        return item_quantity_available;
    }

    public void setItem_quantity_available(int item_quantity_available) {
        this.item_quantity_available = item_quantity_available;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_sold_by() {
        return item_sold_by;
    }

    public void setItem_sold_by(String item_sold_by) {
        this.item_sold_by = item_sold_by;
    }

    public double getItem_review() {
        return item_review;
    }

    public void setItem_review(double item_review) {
        this.item_review = item_review;
    }
}
