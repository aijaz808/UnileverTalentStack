package com.unilever.commonservice.profile.document.service;

import com.unilever.commonservice.profile.document.dto.DocumentDto;
import com.unilever.utilityservice.exception.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.unilever.utilityservice.common.Assert.notNull;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Log4j2
public class DocumentService {

    private static final String DOCUMENT_PATH="/opt/tomcat/webapps/upload-documents";
    //private static final String DOCUMENT_PATH="D:/upload_documents";
    public Boolean uploadDocument(DocumentDto documentDto) throws Exception {

        String fileDir = DOCUMENT_PATH + "/" + documentDto.getProcessAcronym() + "/" +  documentDto.getCandidateId();
        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdir();

        }


        String fileNameWithExtension = documentDto.getFileName()
                + (documentDto.getDocumentType() != null ? ("." + documentDto.getDocumentType()) : "");
        byte[] bytes = Base64.decodeBase64(documentDto.getBase64().getBytes());

        writeByte(fileDir + "/" + fileNameWithExtension, bytes);
        return true;
    }

    public void writeByte(String fileName, byte[] bytes) throws Exception {
        FileOutputStream os = new FileOutputStream(new File(fileName));
        os.write(bytes);
        log.info("Successfully byte inserted.");
        os.close();
    }

    public List<String> getAllFileNames(String processAcronym , Long subDirectory) {
        List<String> resultList = new ArrayList<>();
        String fileDir = DOCUMENT_PATH + "/" + processAcronym ;
        if ( subDirectory != null) {
            fileDir += "/" + subDirectory;
        }

        File dir = new File(fileDir);
        if (dir.exists()) {
            File[] listOfFiles = dir.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    resultList.add(listOfFiles[i].getName());
                }
            }
        }
        return resultList;

    }

    public String downloadFile(DocumentDto request) {
        String fileDir = DOCUMENT_PATH + "/" + request.getProcessAcronym() ;
        if (request.getCandidateId() != null
                && request.getCandidateId() != 0L) {
            fileDir += "/" + request.getCandidateId();
        }
        if (request.getSubDirectory() != null) {
            fileDir += "/" + request.getSubDirectory();
        }

        File dir = new File(fileDir);

        if (dir.exists()) {
            File file = new File(fileDir + "/" + request.getFileName());
            if (file.exists()) {
                return fileDir + "/" + request.getFileName();
            } else {
                throw new EntityNotFoundException("File not exists.");
            }
        } else {
            throw new EntityNotFoundException("Directory not exists.");
        }
    }

    public Boolean deleteDocument(DocumentDto documentDto) throws IOException {

        notNull(documentDto.getCandidateId(), "Candidate Id cannot be null");
        String fileDir = DOCUMENT_PATH + "/" + documentDto.getProcessAcronym() ;
        if (documentDto.getCandidateId() != null) {
            fileDir += "/" + documentDto.getCandidateId();


        }

        File dir = new File(fileDir);
        FileUtils.forceDelete(dir);
       // dir.delete();
        /*if (dir.exists()) {
            File file = new File(fileDir + "/" + documentDto.getFileName());
            if (file.exists()) {

                file.delete();
            } else {
                throw new EntityNotFoundException("File not exists.");
            }
        } else {
            throw new EntityNotFoundException("Directory not exists.");
        }*/
        return true;
    }
}
