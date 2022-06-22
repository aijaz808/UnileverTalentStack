package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.Code;
import com.unilever.utilityservice.dto.DefaultLabelValue;
import liquibase.pro.packaged.Q;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {

    @Query("Select new  com.unilever.utilityservice.dto.DefaultLabelValue(c.id, c.codeValue) from Code c where c.codeTypeId = :codeTypeId and c.active= 1")
    List<DefaultLabelValue> findCodeValuesByCodeTypeId(Long codeTypeId);
}
