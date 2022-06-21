package com.unilever.commonservice.profile.service;

import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.mapper.CommonMapper;
import com.unilever.commonservice.profile.model.Role;
import com.unilever.commonservice.profile.repository.RoleRepository;
import com.unilever.utilityservice.dto.DefaultLabelValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentStackService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CommonMapper mapper;
    public RoleDto saveRole(RoleDto roleDto) {

        Role role;

        if(roleDto.getId() != null && roleDto.getId().equals(0L)){
            role= roleRepository.findById(roleDto.getId()).get();

        }
        else {
            role= new Role();

        }
        role= mapper.convert(roleDto, role);
        role= roleRepository.save(role);
        roleDto=mapper.convert(role);
        return roleDto;
    }


    public List<DefaultLabelValue> getRoles() {

        List<DefaultLabelValue> roles=roleRepository.findAllRoles();

        return roles;
    }
}
