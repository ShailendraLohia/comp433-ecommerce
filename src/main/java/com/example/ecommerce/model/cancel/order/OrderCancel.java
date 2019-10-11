package com.example.ecommerce.model.cancel.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cancel_order")
public class OrderCancel {
    @Id
    private String cancelOrderId;
    private String cartId;
    private String reasonForReturn;
    private double totalRefundMoney;
    private Date cancelOrderDate;
    @OneToMany(mappedBy = "orderCancel")
    private Set<ReturnItems> returnItems;
}
