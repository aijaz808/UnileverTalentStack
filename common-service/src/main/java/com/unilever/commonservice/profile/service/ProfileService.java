package com.unilever.commonservice.profile.service;

import com.unilever.commonservice.profile.dto.ProfileDto;
import com.unilever.commonservice.profile.mapper.CommonMapper;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    CommonMapper mapper;
    public ProfileDto getProfile(String userName) {
        Profile profile = profileRepository.findByUserName(userName).orElse(null);
        if(profile == null || !profile.getActive())
            throw new EntityNotFoundException("Profile registered with CNIC not found");
        return mapper.convert(profile);
    }

    public ProfileDto getProfile(Long profileId) {
        Profile profile = profileRepository.findById(profileId).orElse(null);
        return mapper.convert(profile);
    }
}
