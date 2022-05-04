package com.wolverine.solutions.accountservice.enums.entity;

import com.wolverine.solutions.commons.util.DateAudit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@SQLDelete(sql = "UPDATE parent_category SET is_deleted = true WHERE id=?")
//@Where(clause = "is_deleted = false")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "is_deleted = :isDeleted"
)
@Table(name = "parent_category")
public class ParentCategory extends DateAudit {
    @Id
    @Column(name = "id", nullable = false)
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

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentCategory", targetEntity = Category.class)
//    private List<Category> categoryList = new ArrayList<>();
}