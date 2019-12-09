package com.example.ecommerce.service.products.representation;

//import com.example.ecommerce.service.link.AbstractRepresentation;
import com.example.ecommerce.service.AbstractRepresentation;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation extends AbstractRepresentation {

    private long item_id;
    private String item_category;
    private double item_price;
    private int item_quantity_available;
    private double item_review;
    // @JsonIgnore
    private String item_name;
    @JsonIgnore
    private String item_description;
    @JsonIgnore
    private String item_sold_by;


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



    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

}
