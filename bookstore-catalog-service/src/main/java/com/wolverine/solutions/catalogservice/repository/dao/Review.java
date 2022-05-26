package com.wolverine.solutions.catalogservice.repository.dao;

import com.wolverine.solutions.commons.util.DateAudit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "review_id", updatable = false, nullable = false)
    private String reviewId;

    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "rating_value", nullable = false)
    @Min(1)
    @Max(5)
    private double ratingValue;

    @Column(name = "review_message", columnDefinition = "varchar(1000)")
    private String reviewMessage;

}
