package org.photoclub.storage;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    private final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    private final String imageStorageLocation;

    public FileStorageService(@Value("${app.storage.location}") String storageLocation) {
        this.imageStorageLocation = storageLocation + "/img/";
        initStorageDirectory(Paths.get(this.imageStorageLocation));
    }

    private void initStorageDirectory(Path directoryPath) {
        try {
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
                logger.info("Storage directory created: {}", directoryPath.toAbsolutePath());
            } else {
                logger.info("Storage directory exists: {}", directoryPath.toAbsolutePath());
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to create storage directory", e);
        }
    }

    public String saveImage(MultipartFile file) {
        return saveFile(file, imageStorageLocation);
    }

    private String saveFile(MultipartFile file, String storageLocation) {
        Path filePath = createFilePath(file, storageLocation);
        try {
            // Ensure parent directories exist before saving
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.getFileName().toString();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to save file", e);
        }
    }

    private Path createFilePath(MultipartFile file, String storageLocation) {
        String originalFileName = file.getOriginalFilename();
        String fileBaseName = FilenameUtils.getBaseName(originalFileName);
        String fileExtension = FilenameUtils.getExtension(originalFileName);
        String completeFilename;
        Path filePath;
        int fileIndex = 0;
        do {
            completeFilename = fileBaseName + (fileIndex > 0 ? fileIndex : "") + "." + fileExtension;
            filePath = Paths.get(storageLocation, completeFilename);
            fileIndex++;
        } while (Files.exists(filePath));
        return filePath;
    }
}
