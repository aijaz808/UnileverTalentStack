package com.unilever.authservice.service;

import com.unilever.authservice.exception.TokenRefreshException;
import com.unilever.authservice.model.RefreshToken;
import com.unilever.authservice.repository.RefreshTokenRepository;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.repository.ProfileRepository;
import com.unilever.utilityservice.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    //@Value("${app.auth.jwt.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs =21600000L ;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
    public RefreshToken createRefreshToken(Long userId) {
        RefreshToken refreshToken = new RefreshToken();
        Optional<Profile> profile=profileRepository.findById(userId);
        if(profile != null) {
            refreshToken.setProfile(profileRepository.findById(userId).get());
            refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken = refreshTokenRepository.save(refreshToken);
            return refreshToken;
        }
        else{
            throw new UnauthorizedException();
        }
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    @Transactional
    public Long deleteByUserId(Long userId) {
        return refreshTokenRepository.deleteByProfile(profileRepository.findById(userId).get());
    }
}
