package com.wolverine.solutions.accountservice.enums.entity;

import com.wolverine.solutions.commons.util.DateAudit;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tags_to_business_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TagsToBusinessProfile extends DateAudit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_profile_id", nullable = false)
    private BusinessProfile businessProfile;


}