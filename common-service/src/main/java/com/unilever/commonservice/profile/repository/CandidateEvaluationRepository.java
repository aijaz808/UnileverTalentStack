package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.CandidateEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEvaluationRepository extends JpaRepository<CandidateEvaluation, Long> {
}
