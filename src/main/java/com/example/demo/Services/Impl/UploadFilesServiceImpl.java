package com.example.demo.Services.Impl;

import com.example.demo.Services.IUploadFilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFilesServiceImpl implements IUploadFilesService {
    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {

        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5*1024*1024;

            if (fileSize>maxFileSize){
                return "El tamaño del archivo debe ser menor o igual 10MB";
            }
            if (!fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".jpeg") &&
                    !fileOriginalName.endsWith(".png")
            ){
                return "Solo archivos JPG,JPEG,PNG";
            }
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;
            File carpeta = new File("src/main/resources/picture/");
            if (!carpeta.exists()){
                carpeta.mkdirs();
            }
            Path path= Paths.get("src/main/resources/picture/" + newFileName);
            Files.write(path, bytes);
            return "Carga exitosa";
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
