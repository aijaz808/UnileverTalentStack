package com.unilever.commonservice.profile.service;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.mapper.CommonMapper;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.model.Role;
import com.unilever.commonservice.profile.repository.CandidateRepository;
import com.unilever.commonservice.profile.repository.CodeRepository;
import com.unilever.commonservice.profile.repository.RoleRepository;
import com.unilever.utilityservice.constant.AppCode;
import com.unilever.utilityservice.dto.DefaultLabelValue;
import com.unilever.utilityservice.common.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.unilever.utilityservice.common.Assert.notNull;

@Service
public class TalentStackService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CommonMapper mapper;

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    CandidateRepository candidateRepository;

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

    public Map<String, List<DefaultLabelValue>> getTalentStackDropdowns() {

        List<DefaultLabelValue> genderList= codeRepository.findCodeValuesByCodeTypeId(AppCode.GENDER_CODE);
        List<DefaultLabelValue> hiringList= codeRepository.findCodeValuesByCodeTypeId(AppCode.HIRING_STATUS);
        List<DefaultLabelValue> finalDecisionList= codeRepository.findCodeValuesByCodeTypeId(AppCode.FINAL_DECISION);
        List<DefaultLabelValue> gradingScaleList=codeRepository.findCodeValuesByCodeTypeId(AppCode.GRADING_SCALE);

        Map<String, List<DefaultLabelValue>> dropdownList= new HashMap<>();

        dropdownList.put("genderList", genderList);
        dropdownList.put("hiringList", hiringList);
        dropdownList.put("finalDecisionList", finalDecisionList);
        dropdownList.put("gradingScaleList", gradingScaleList);

        return dropdownList;

    }


    public CandidateDto saveCandidateInformation(CandidateDto candidateDto) {

        Candidate candidate;

        if(candidateDto.getId() != null && !candidateDto.getId().equals(0L)){
            candidate= candidateRepository.findById(candidateDto.getId()).get();

        }
        else {
            candidate= new Candidate();

        }
        candidate= mapper.convert(candidateDto, candidate);
        candidate= candidateRepository.save(candidate);
        candidateDto=mapper.convert(candidate);
        return candidateDto;

    }


    public CandidateDto getCandidateInformation(Long candidateId) {

         notNull(candidateId,"Candidate Id cannot be null");

         Candidate candidate=candidateRepository.findById(candidateId).get();
         CandidateDto candidateDto= mapper.convert(candidate);
         if(candidateDto.getGenderId() != null){
             candidateDto.setGender(codeRepository.findById(candidateDto.getGenderId()).get().getCodeValue());
         }
         if(candidateDto.getRoleId()!=null){
             candidateDto.setRole(roleRepository.findById(candidateDto.getRoleId()).get().getRoleName());
         }
         if(candidateDto.getHiringStatusId() != null){
             candidateDto.setHiringStatus(codeRepository.findById(candidateDto.getHiringStatusId()).get().getCodeValue());
         }

         return candidateDto;
    }


}
