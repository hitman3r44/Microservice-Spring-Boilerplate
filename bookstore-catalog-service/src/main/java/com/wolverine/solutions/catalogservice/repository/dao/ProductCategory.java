package com.wolverine.solutions.catalogservice.repository.dao;

import com.wolverine.solutions.commons.util.DateAudit;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category")
@Builder
public class ProductCategory extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_category_id", updatable = false, nullable = false)
    private String productCategoryId;

    @Column(name = "product_category_name", nullable = false)
    private String productCategoryName;

    @OneToMany(
            mappedBy = "productCategory",
            cascade = CascadeType.ALL
    )
    private List<Product> products;

    @Column(name = "description")
    private String description;
}
