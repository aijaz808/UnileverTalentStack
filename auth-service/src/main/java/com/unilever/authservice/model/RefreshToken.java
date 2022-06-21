package com.unilever.authservice.model;

import com.unilever.commonservice.profile.model.Profile;
import com.unilever.utilityservice.model.AbstractEntity;
import lombok.*;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;


import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "REFRESH_TOKEN")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class RefreshToken extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMON_PROFILE_ID")
    private Profile profile;
    @Column(name ="TOKEN")
    private String token;
    @Column(name = "EXPIRY_DATE")
    private Instant expiryDate;
}