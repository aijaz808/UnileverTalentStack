package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByRoleIdAndActive(Long roleId, Boolean aTrue);
}
