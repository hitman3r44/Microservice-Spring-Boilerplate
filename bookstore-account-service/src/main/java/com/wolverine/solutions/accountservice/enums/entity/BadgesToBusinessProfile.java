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
@Table(name = "badges_to_business_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BadgesToBusinessProfile extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @JsonIgnoreProperties("badges")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_profile_id", nullable = false, referencedColumnName = "id")
    private BusinessProfile businessProfile;

    @Column(name = "badge_name")
    String badgeName;
}