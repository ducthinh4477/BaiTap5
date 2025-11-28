package vn.iotstar.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static String saveFile(String uploadDir, MultipartFile file) {
        try {
            if (file.isEmpty()) return null;

            String originalName = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + "_" + originalName;

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("Upload file error: " + e.getMessage());
        }
    }
}
