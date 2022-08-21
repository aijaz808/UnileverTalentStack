package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.Role;
import com.unilever.utilityservice.dto.DefaultLabelValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {

    /*@Query("Select new com.unilever.utilityservice.dto.DefaultLabelValue(r.id, r.roleName) from Role r where r.active = 1")
    List<DefaultLabelValue> findAllRoles();*/

    Role findByUserName(String userName);

    Role findByRoleName(String cellValue);
}
