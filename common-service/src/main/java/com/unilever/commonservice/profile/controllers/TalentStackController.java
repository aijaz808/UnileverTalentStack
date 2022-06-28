package com.unilever.commonservice.profile.controllers;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.CandidateEvaluationDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.service.TalentStackService;
import com.unilever.utilityservice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @GetMapping("/getCandidateDashboard/{roleId}")
    public ResponseEntity<?> getCandidateDashboard(@PathVariable Long roleId) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getCandidateDashboard(roleId), HttpStatus.OK);
    }

    @GetMapping("/getLineManagerInformation/{userName}")
    public ResponseEntity<?> getLineManagerInformation(@PathVariable String userName) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getLineManagerInformation(userName), HttpStatus.OK);
    }

    @PostMapping("/import-order-excel")
    public ResponseEntity<?> importExcelFile(@RequestParam("file") MultipartFile files)throws IOException {

        return  ResponseHandler.buildResponseData(talentStackService.importExcelFile(files), HttpStatus.OK);
    }

    @PostMapping("/saveCandidateEvaluation")
    public ResponseEntity<?> saveCandidateEvaluation(@RequestBody CandidateEvaluationDto candidateEvaluationDto) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.saveCandidateEvaluation(candidateEvaluationDto), HttpStatus.OK);
    }

    @GetMapping("/getCandidateEvaluation/{candidateEvaluationId}")
    public ResponseEntity<?> getCandidateEvaluation(@PathVariable Long candidateEvaluationId) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getCandidateEvaluation(candidateEvaluationId), HttpStatus.OK);
    }

    @GetMapping("/getCounts/{roleId}")
    public ResponseEntity<?> getCounts(@PathVariable Long roleId) throws Exception{
        return ResponseHandler.buildResponseData(talentStackService.getCounts(roleId), HttpStatus.OK);
    }
}
