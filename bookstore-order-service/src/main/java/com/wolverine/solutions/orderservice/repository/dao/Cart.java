package com.wolverine.solutions.orderservice.repository.dao;

import com.wolverine.solutions.commons.util.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "cart_id", updatable = false, nullable = false)
    private String cartId;

    @NotEmpty
    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();
    
    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    public void dismissChild(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

    @PreRemove
    public void dismissChild() {
        this.cartItems.forEach(CartItem::dismissParent); // SYNCHRONIZING THE OTHER SIDE OF RELATIONSHIP
        this.cartItems.clear();
    }
}
