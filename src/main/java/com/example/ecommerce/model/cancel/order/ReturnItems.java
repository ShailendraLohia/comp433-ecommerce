package com.example.ecommerce.model.cancel.order;

import com.example.ecommerce.model.cancel.order.OrderCancel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="return_items")
public class ReturnItems {
    @Id
    private String item_id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="cancelOrderId", nullable = false)
    private OrderCancel orderCancel;
}
