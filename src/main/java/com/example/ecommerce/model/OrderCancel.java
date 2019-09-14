package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cancel_order")
public class OrderCancel {
    @Id
    private String cancelOrderId;
    private String order_id;
    private List<Item> returnItems;
    private String reasonForReturn;
    private double totalRefundMoney;
    private Date cancelOrderDate;
}
