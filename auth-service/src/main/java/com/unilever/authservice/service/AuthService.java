package com.unilever.authservice.service;

import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.repository.ProfileRepository;
import com.unilever.utilityservice.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(readOnly = true)
public class AuthService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Profile login(Map<String, String> request) {
        String mess= passwordEncoder.encode(request.get("password"));
        Profile profile = profileRepository.findByUserName(request.get("username")).orElse(null);

            if (profile == null || !profile.getActive()) {
                throw new UnauthorizedException();
            }

        if (!passwordEncoder.matches(request.get("password"), profile.getPassword())) {

            throw new UnauthorizedException();
        }
        return profile;
    }

}