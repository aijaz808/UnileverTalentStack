package com.unilever.utilityservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class AbstractEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @CreatedDate
    @Column(name = "create_datetime")
    public Date createdDate;

    @CreatedBy
    @Column(name = "created_by")
    public String createdBy;

    @LastModifiedDate
    @Column(name = "modified_datetime")
    public Date modifiedDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    public String modifiedBy;

    @NotNull
    @Column(name = "active_ind" ,columnDefinition="boolean default true")
    public Boolean active=Boolean.TRUE;

    @Column(name = "LOCK_VERSION")
    public Integer lockVersion = 1;


    @PreUpdate
    protected void onUpdate() {
        modifiedDate= modifiedDate == null ? new Date():modifiedDate;
        lockVersion = lockVersion == null ? 1 : lockVersion + 1;
        active = (active == null || active.booleanValue() == true ? true : false);
        modifiedBy = modifiedBy == null ? (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : modifiedBy;
    }
}