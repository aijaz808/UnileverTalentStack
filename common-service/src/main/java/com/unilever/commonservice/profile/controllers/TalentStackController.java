package com.unilever.commonservice.profile.controllers;

import com.unilever.commonservice.profile.document.dto.DocumentDto;
import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.CandidateEvaluationDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.export.UserExcelExporter;
import com.unilever.commonservice.profile.mapper.CommonMapper;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.repository.CandidateRepository;
import com.unilever.commonservice.profile.repository.CodeRepository;
import com.unilever.commonservice.profile.repository.RoleRepository;
import com.unilever.commonservice.profile.service.TalentStackService;
import com.unilever.utilityservice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/talentStack")
@CrossOrigin("*")
public class TalentStackController {

    @Autowired
    TalentStackService talentStackService;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CommonMapper mapper;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CodeRepository codeRepository;

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

    @PostMapping(value="/import-order-excel" )
    public ResponseEntity<?> importExcelFile(@RequestBody DocumentDto documentDto) throws Exception {

        return  ResponseHandler.buildResponseData(talentStackService.importExcelFile(documentDto), HttpStatus.OK);
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


    @GetMapping("/exportExcel/{roleId}")
    public ResponseEntity<?>  exportToExcel(HttpServletResponse response, @PathVariable Long roleId) throws IOException {
      /*  response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xls";
        response.setHeader(headerKey, headerValue);*/

        List<Candidate> listCandidates = candidateRepository.findByRoleIdAndActive(roleId, Boolean.TRUE);
        List<CandidateDto> candidateDtoList= new ArrayList<>();
        listCandidates.stream().forEach(c -> {
            CandidateDto candidateDto= mapper.convert(c);
            candidateDto.setGender(candidateDto.getGenderId()== null ? "" :  codeRepository.findById(candidateDto.getGenderId()).get().getCodeValue());
            candidateDto.setRole(candidateDto.getRoleId()==null ? "" : roleRepository.findById(candidateDto.getRoleId()).get().getRoleName());

            candidateDto.setHiringStatus(candidateDto.getHiringStatusId()== null ? "" : codeRepository.findById(candidateDto.getHiringStatusId()).get().getCodeValue());
            candidateDtoList.add(candidateDto);
        });
        UserExcelExporter excelExporter = new UserExcelExporter(candidateDtoList);

        excelExporter.export(response);
        File file = new File("opt/tomcat/webapps/upload-documents/Candidates/student_database_geeks_for_geeks.xlsx");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename= Candidates.xlsx" + "\"")
                .contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

    }
}
