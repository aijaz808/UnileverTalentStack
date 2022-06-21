package com.unilever.authservice.repository;

import com.unilever.authservice.model.RefreshToken;
import com.unilever.commonservice.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByToken(String token);

    Long deleteByProfile(Profile profile);
}
