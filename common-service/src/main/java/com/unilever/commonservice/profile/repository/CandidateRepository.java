package com.unilever.commonservice.profile.repository;

import com.unilever.commonservice.profile.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
