package com.project.compression;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    
    @Value("${files.upload-dir}")
    private String uploadDir;

    // Method to upload files 
    public byte[] uploadFilesAndZip(MultipartFile[] files) throws IOException{
        List<Path> uploadedFilePaths = new ArrayList<>();
        // Copy and save uploadedFiles
        String workingDir = System.getProperty("user.dir");
        System.out.println("workingDir : "+workingDir);
        for(MultipartFile file : files){
            Path filePath = Paths.get(workingDir,uploadDir+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);
            uploadedFilePaths.add(filePath);
        }
        // ZIP uploaded files
        String uniqueZipFileName = "File_"+new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+".zip";
        return zipFilesAndDownload(uploadedFilePaths.toArray(new Path[0]),uniqueZipFileName);
    }

    public byte[] zipFilesAndDownload(Path[] filesToZip, String zipFileName) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ZipOutputStream zipOut = new ZipOutputStream(byteArrayOutputStream)){
            zipOut.setLevel(9);
            for(Path file:filesToZip){
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipOut.putNextEntry(zipEntry);
                Files.copy(file,zipOut);
                zipOut.closeEntry();
                file.toFile().delete();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] downloadFile(String fileName) throws IOException{
        Path path = Paths.get(uploadDir+File.separator+fileName);
        try (InputStream inputStream = new FileInputStream(path.toFile())) {
            return inputStream.readAllBytes();
        }
    }
}
