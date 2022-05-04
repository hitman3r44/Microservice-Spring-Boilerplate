package com.wolverine.solutions.accountservice.enums.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wolverine.solutions.commons.util.DateAudit;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends DateAudit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "isFeatured")
    private boolean isfeatured;

    @Column(name = "isForecastingEnabled")
    private boolean isforecastingenabled;

    @Column(name = "status")
    private String status;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_category_id_id", referencedColumnName = "id")
//    private ParentCategory parentCategory;

    @JsonIgnoreProperties("categoryList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_profile_id", nullable = false, referencedColumnName = "id")
    private BusinessProfile businessProfile;
}