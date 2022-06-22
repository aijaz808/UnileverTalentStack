package com.unilever.commonservice.profile.controllers;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.service.TalentStackService;
import com.unilever.utilityservice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/talentStack")
@CrossOrigin("*")
public class TalentStackController {

    @Autowired
    TalentStackService talentStackService;

    @PostMapping("/saveRole")
    public ResponseEntity<?> saveRole(@RequestBody RoleDto roleDto) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.saveRole(roleDto), HttpStatus.OK);
    }

    @GetMapping("/getRoles")
    public ResponseEntity<?> getRoles() throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/getTalentStackDropdowns")
    public ResponseEntity<?> getTalentStackDropdowns() throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getTalentStackDropdowns(), HttpStatus.OK);
    }

    @PostMapping("/saveCandidateInformation")
    public ResponseEntity<?> saveCandidateInformation(@RequestBody CandidateDto candidateDto) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.saveCandidateInformation(candidateDto), HttpStatus.OK);
    }

    @GetMapping("/getCandidateInformation/{candidateId}")
    public ResponseEntity<?> getCandidateInformation(@PathVariable Long candidateId) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getCandidateInformation(candidateId), HttpStatus.OK);
    }
}
