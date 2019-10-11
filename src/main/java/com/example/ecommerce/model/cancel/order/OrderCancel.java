package com.example.ecommerce.model.cancel.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

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

    public OrderCancel() {}

    public String getCancelOrderId() {
        return cancelOrderId;
    }

    public void setCancelOrderId(String cancelOrderId) {
        this.cancelOrderId = cancelOrderId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getReasonForReturn() {
        return reasonForReturn;
    }

    public void setReasonForReturn(String reasonForReturn) {
        this.reasonForReturn = reasonForReturn;
    }

    public double getTotalRefundMoney() {
        return totalRefundMoney;
    }

    public void setTotalRefundMoney(double totalRefundMoney) {
        this.totalRefundMoney = totalRefundMoney;
    }

    public Date getCancelOrderDate() {
        return cancelOrderDate;
    }

    public void setCancelOrderDate(Date cancelOrderDate) {
        this.cancelOrderDate = cancelOrderDate;
    }

    public Set<ReturnItems> getReturnItems() {
        return returnItems;
    }

    public void setReturnItems(Set<ReturnItems> returnItems) {
        this.returnItems = returnItems;
    }
}
