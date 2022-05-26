package com.wolverine.solutions.catalogservice.repository.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolverine.solutions.catalogservice.web.ProductResponse;
import com.wolverine.solutions.commons.util.DateAudit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String description;
    private double price;

    @Column(name = "product_image_id")
    private String imageId;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @Column(name = "available_item_count")
    private int availableItemCount;

    public String getProductCategory() {
        return productCategory.getProductCategoryName();
    }

    public static ProductResponse fromEntity(Product product) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(product, ProductResponse.class);
    }
}
