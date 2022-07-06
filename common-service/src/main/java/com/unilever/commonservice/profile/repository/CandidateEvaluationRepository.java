package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.CandidateEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateEvaluationRepository extends JpaRepository<CandidateEvaluation, Long> {

    List<CandidateEvaluation> findByRoleIdAndActive(Long roleId, Boolean aTrue);
}
