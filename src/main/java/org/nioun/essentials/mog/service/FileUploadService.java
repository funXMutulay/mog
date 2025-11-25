package org.nioun.essentials.mog.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadService {

    public static void uploadFile(String uploadDir ,
                       String fileName ,
                       MultipartFile uploadedFile) throws IOException{

    Path uploadPath = Paths.get(uploadDir);
    
    if(!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
    }

    try{
        InputStream  inputStream= uploadedFile.getInputStream();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING); 
        
    }catch(IOException e){
        throw new IOException(e.getMessage());
    }

    }

}
