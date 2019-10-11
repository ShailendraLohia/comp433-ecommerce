package com.example.ecommerce.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventory_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
