package com.project.compression;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private static final Logger log = Logger.getLogger(FileController.class.getName());
    
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<byte[]> uploadFilesAndGetZip(@RequestParam("files") MultipartFile[]files){
        try{
            byte[] zipFile = fileService.uploadFilesAndZip(files);
            String zipFileName = "File_"+new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+".zip";
            HttpHeaders httpHeaders =  new HttpHeaders();
            httpHeaders.add("Content-Disposition", "attachment; filename="+zipFileName);
            return ResponseEntity.ok()
                    .headers(httpHeaders)
                    .body(zipFile);
        }catch(IOException e){
            log.severe("Error in controller : "+ e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/upload/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName){
        try {
            byte[] fileContent = fileService.downloadFile(fileName);
            return ResponseEntity.ok().body(fileContent); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
