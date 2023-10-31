package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.util.CloudStorageHelper;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
    final CloudStorageHelper cloudStorageHelper;
    @PostMapping("/announce")
    public ResponseEntity<?> getFileUrl(@RequestPart(value = "file")
                                        MultipartFile file) throws IOException, ServletException{
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file, "projectstorage-165a3.appspot.com"));
    }
}

