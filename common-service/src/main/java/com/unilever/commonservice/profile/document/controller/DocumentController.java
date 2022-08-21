package com.unilever.commonservice.profile.document.controller;

import com.unilever.commonservice.profile.document.dto.DocumentDto;
import com.unilever.commonservice.profile.document.service.DocumentService;
import com.unilever.utilityservice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/document")
@CrossOrigin("*")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/uploadDocument")
    public ResponseEntity<?> uploadDocument(@RequestBody DocumentDto request) throws Exception {
        return ResponseHandler
                .buildResponseData(documentService.uploadDocument(request), HttpStatus.CREATED);
    }

    @GetMapping("/getFileNames/{processAcronym}/{subDirectory}")
    public ResponseEntity<?> getFileNames(@PathVariable("processAcronym") String processAcronym, @PathVariable("subDirectory") Long subDirectory) {
        return ResponseHandler
                .buildResponseData(documentService.getAllFileNames(processAcronym, subDirectory), HttpStatus.OK);
    }

    @PostMapping("/downloadFile")
    public ResponseEntity<?> downloadFile(@RequestBody DocumentDto request) throws FileNotFoundException {
        String generatedFileName = documentService.downloadFile(request);
        if (request.getFileName() != null && !request.getFileName().equals("")) {
            File file = new File(generatedFileName);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + request.getFileName() + "\"")
                    .contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
        }
        return null;
    }

    @PostMapping("/deleteDocument")
    public ResponseEntity<?> deleteDocument(@RequestBody DocumentDto request) throws IOException {
        return ResponseHandler
                .buildResponseData(documentService.deleteDocument(request), HttpStatus.ACCEPTED);
    }
}