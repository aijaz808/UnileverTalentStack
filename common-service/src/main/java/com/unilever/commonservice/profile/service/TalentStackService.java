package com.unilever.commonservice.profile.service;

import com.unilever.commonservice.profile.constants.HiringStatus;
import com.unilever.commonservice.profile.constants.RoleType;
import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.CandidateEvaluationDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.mapper.CommonMapper;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.model.CandidateEvaluation;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.model.Role;
import com.unilever.commonservice.profile.repository.*;
import com.unilever.utilityservice.constant.AppCode;
import com.unilever.utilityservice.dto.DefaultLabelValue;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    CandidateEvaluationRepository candidateEvaluationRepository;
    public RoleDto saveRole(RoleDto roleDto) {

        Role role;

        if(roleDto.getId() != null && roleDto.getId().equals(0L)){
            role= roleRepository.findById(roleDto.getId()).get();

        }
        else {
            role= new Role();

        }
        Profile profile=new Profile();
        profile.withUserName(roleDto.getUserName())
                .withPassword(passwordEncoder.encode("123"))
                .withRoleType(RoleType.TALENT_EVALUATOR);
        profileRepository.save(profile);
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

         Optional<Candidate> candidate=candidateRepository.findById(candidateId);
          CandidateDto candidateDto= new CandidateDto();
         if(!candidateId.equals(0L) && candidate != null ) {
              candidateDto = mapper.convert(candidate.get());
             if (candidateDto.getGenderId() != null) {
                 candidateDto.setGender(codeRepository.findById(candidateDto.getGenderId()).get().getCodeValue());
             }
             if (candidateDto.getRoleId() != null) {
                 candidateDto.setRole(roleRepository.findById(candidateDto.getRoleId()).get().getRoleName());
             }
             if (candidateDto.getHiringStatusId() != null) {
                 candidateDto.setHiringStatus(codeRepository.findById(candidateDto.getHiringStatusId()).get().getCodeValue());
             }
         }
         return candidateDto;
    }


    public List<CandidateDto> getCandidateDashboard(Long roleId) {

        notNull(roleId, "Role id cannot be null");

        List<Candidate> candidateList = candidateRepository.findByRoleIdAndActive(roleId, Boolean.TRUE);
        List<CandidateDto> candidateDtoList=new ArrayList<>();

        candidateList.stream().forEach( candidate -> {
            CandidateDto candidateDto = mapper.convert(candidate);
            candidateDto.setHiringStatus(codeRepository.findById(candidateDto.getHiringStatusId()).get().getCodeValue());
            candidateDto.setGender(codeRepository.findById(candidateDto.getGenderId()).get().getCodeValue());
            candidateDto.setRole(codeRepository.findById(candidateDto.getRoleId()).get().getCodeValue());
            candidateDto.setRole(roleRepository.findById(candidateDto.getRoleId()).get().getRoleName());
            candidateDtoList.add(candidateDto);
        });

        return candidateDtoList;

    }

     public RoleDto getLineManagerInformation(String  userName) {

        notNull(userName, "User name cannot be null");

        Role role= roleRepository.findByUserName(userName);
        RoleDto roleDto= mapper.convert(role);
        return roleDto;
     }


    public List<Candidate> importExcelFile(MultipartFile files) throws IOException {

        List<Candidate> candidateList = new ArrayList<>();

        InputStream inputStreamResource= files.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        // Read student data form excel file sheet1.
        XSSFSheet worksheet = workbook.getSheetAt(0);
        // Read student data form excel file sheet1.
        worksheet.removeRow(worksheet.getRow(0));

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                XSSFRow row = worksheet.getRow(index);
                Candidate candidate= new Candidate();

                candidate.setCandidateName(getCellValue(row, 2));
                candidate.setCurrentDesignation(getCellValue(row, 3));
                candidate.setCurrentDesignation(getCellValue(row, 4));
                candidate.setExperience(convertStringToInt(getCellValue(row, 5)));
                candidate.setIsUnileverBefore(getCellValue(row, 6) == "YES" ? Boolean.FALSE : Boolean.TRUE);
                candidate.setGenderId(codeRepository.findByCodeValue(getCellValue(row, 7)).getId());
                candidate.setIsSourcedByHeadHunter(getCellValue(row, 8) == "YES" ? Boolean.FALSE : Boolean.TRUE);
                candidate.setRoleId(roleRepository.findByRoleName(getCellValue(row, 9)).getId());
                candidate.setComments(getCellValue(row, 10));
                candidate.setHiringStatusId(HiringStatus.get(getCellValue(row, 11)).longValue());
                candidate.setProfileUrl(getCellValue(row, 12));
                candidate.setIsInterviewed(getCellValue(row, 13) == "YES" ? Boolean.FALSE : Boolean.TRUE);
                candidate = candidateRepository.save(candidate);

                candidateList.add(candidate);
            }
        }

        return candidateList;
     }

    private Long convertStringToInt(String str) {
        Long result = 0L;
        if (str == null || str.isEmpty() || str.trim().isEmpty()) {
            return result;
        }
        result = Long.parseLong(str);
        return result;
    }
    private String getCellValue(Row row, int cellNo) {
        DataFormatter formatter = new DataFormatter();
        Cell cell = row.getCell(cellNo);
        return formatter.formatCellValue(cell);
    }

    public CandidateEvaluationDto saveCandidateEvaluation(CandidateEvaluationDto candidateEvaluationDto) {

        notNull(candidateEvaluationDto.getCandidateId(), "Candidate Id cannot be null");

        CandidateEvaluation candidateEvaluation;

        if(candidateEvaluationDto.getId() != null && !candidateEvaluationDto.getId().equals(0L)){
            candidateEvaluation= candidateEvaluationRepository.findById(candidateEvaluationDto.getId()).get();

        }
        else {
            candidateEvaluation= new CandidateEvaluation();

        }
        candidateEvaluation= mapper.convert(candidateEvaluationDto, candidateEvaluation);
        candidateEvaluation= candidateEvaluationRepository.save(candidateEvaluation);
        candidateEvaluationDto =mapper.convert( candidateEvaluation);
        return candidateEvaluationDto;
    }

    public CandidateEvaluationDto getCandidateEvaluation(Long candidateEvaluationId) {

        notNull(candidateEvaluationId,"Candidate Evaluation Id cannot be null");

        Optional<CandidateEvaluation> candidate=candidateEvaluationRepository.findById(candidateEvaluationId);
        CandidateEvaluationDto candidateDto=new CandidateEvaluationDto();
        if(!candidateEvaluationId.equals(0L) && candidate != null) {
             candidateDto = mapper.convert(candidate.get());
            if (candidateDto.getAgilityId() != null) {
                candidateDto.setAgility(codeRepository.findById(candidateDto.getAgilityId()).get().getCodeValue());
            }
            if (candidateDto.getDiversityOfGenderId() != null) {
                candidateDto.setDiversityOfGender(roleRepository.findById(candidateDto.getDiversityOfGenderId()).get().getRoleName());
            }

            if (candidateDto.getDiversityOfGenderId() != null) {
                candidateDto.setDiversityOfGender(roleRepository.findById(candidateDto.getDiversityOfGenderId()).get().getRoleName());
            }
            if (candidateDto.getFinalDecisionId() != null) {
                candidateDto.setFinalDecision(codeRepository.findById(candidateDto.getFinalDecisionId()).get().getCodeValue());
            }
            if (candidateDto.getPassionForHighPerformanceId() != null) {
                candidateDto.setPassionForHighPerformance(codeRepository.findById(candidateDto.getPassionForHighPerformanceId()).get().getCodeValue());
            }
            if (candidateDto.getPersonalMasteryId() != null) {
                candidateDto.setPersonalMastery(roleRepository.findById(candidateDto.getPersonalMasteryId()).get().getRoleName());
            }
            if (candidateDto.getStrategicMindsetId() != null) {
                candidateDto.setStrategicMindset(codeRepository.findById(candidateDto.getStrategicMindsetId()).get().getCodeValue());
            }
            if (candidateDto.getStrongDriveId() != null) {
                candidateDto.setStrongDrive(codeRepository.findById(candidateDto.getStrongDriveId()).get().getCodeValue());
            }
            if (candidateDto.getTechnicalExpertiseId() != null) {
                candidateDto.setTechnicalExpertise(roleRepository.findById(candidateDto.getTechnicalExpertiseId()).get().getRoleName());
            }
        }


        return candidateDto;
    }


    public Map<String, Long> getCounts(Long roleId) {

        notNull(roleId, "RoleId cannot be null");
        List<Candidate> candidate=candidateRepository.findByRoleIdAndActive(roleId, Boolean.TRUE);

        Long candidatesMapped= candidate.stream().filter(c -> Boolean.FALSE.equals(c.getIsInterviewed()) || c.getHiringStatusId().equals(20010L)
                || c.getHiringStatusId().equals(20015L)).count();

        Long declined= candidate.stream().filter(c -> c.getHiringStatusId().equals(20012L)).count();

        Long candidatesInterviewed= candidate.stream().filter(c -> Boolean.TRUE.equals(c.getIsInterviewed())).count();

        Long candidatesHired= candidate.stream().filter(c -> c.getHiringStatusId().equals(20011L)).count();

        Long candidatesParked= candidate.stream().filter(c -> c.getHiringStatusId().equals(20013L)).count();

        List<CandidateEvaluation> candidateEvaluationList =candidateEvaluationRepository.findByRoleIdAndActive(roleId, Boolean.TRUE);

        Long parkedEvaluation= candidateEvaluationList.stream().filter(ce -> ce.getFinalDecisionId().equals(40011L)).count();

        Long hiredEvaluation= candidateEvaluationList.stream().filter(ce -> ce.getFinalDecisionId().equals(40010L)).count();

        Long doNotHireEvaluation= candidateEvaluationList.stream().filter(ce -> ce.getFinalDecisionId().equals(40012L)).count();

        Map<String, Long> counts=new HashMap<>();
        counts.put("CandidatesMapped", candidatesMapped);
        counts.put("CandidatesDeclined", declined);
        counts.put("CandidatesInterviewed", candidatesInterviewed);
        counts.put("CandidatesHired", candidatesHired);
        counts.put("CandidatesParked", candidatesParked);
        counts.put("ShortlistingEvaluation", parkedEvaluation);
        counts.put("hiredEvaluation", hiredEvaluation);
        counts.put("doNotHireEvaluation", doNotHireEvaluation);


        return counts;
    }
}
