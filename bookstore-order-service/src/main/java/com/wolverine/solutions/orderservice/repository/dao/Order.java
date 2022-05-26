package com.wolverine.solutions.orderservice.repository.dao;

import com.wolverine.solutions.commons.util.DateAudit;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "order_id", updatable = false, nullable = false)
    private String orderId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "total_items_price", nullable = false)
    private double totalItemsPrice;

    @Column(name = "total_order_price", nullable = false)
    private double totalOrderPrice;

    @Column(name = "payment_method_id", nullable = false)
    private String paymentMethodId;

    @Column(name = "tax_price", nullable = false)
    private double taxPrice;

    @Column(name = "shipping_price", nullable = false)
    private double shippingPrice;

    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_receipt_url")
    private String paymentReceiptUrl;

    @Column(name = "delivered_date")
    private LocalDateTime deliveredDate;

    @Column(name = "is_delivered")
    private boolean isDelivered;
}