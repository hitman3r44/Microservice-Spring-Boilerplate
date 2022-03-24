package com.wolverine.solutions.orderservice.repository.dao;

import com.wolverine.solutions.commons.util.DateAudit;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "ORDER_BILLING_ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderBillingAddress extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ORDER_BILLING_ID", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderBillingId;

    @Column(name = "ORDER_ID", updatable = false, nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderId;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Pattern(regexp = "[A-Z]{2}", message = "2-letter ISO country code required")
    @NonNull
    private String country;

    @Column(name = "phone")
    private String phone;
}
