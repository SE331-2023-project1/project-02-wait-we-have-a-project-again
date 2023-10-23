package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.dto.AnnouncementDTO;
import se331.lab.rest.entity.Announcement;
import se331.lab.rest.service.AnnouncementService;
import se331.lab.rest.util.CloudStorageHelper;
import se331.lab.rest.util.LabMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
    final CloudStorageHelper cloudStorageHelper;
    final AnnouncementService announcementService;

    @PostMapping("/announcements")
    public ResponseEntity<?> uploadAnnouncement(@RequestPart(value = "file") MultipartFile file,
                                                @RequestParam("title") String title) throws IOException, ServletException {
        String fileUrl = cloudStorageHelper.uploadFile(file, "projectstorage-165a3.appspot.com");
        Announcement announcement = Announcement.builder()
                .title(title)
                .build();
        announcementService.addAnnouncement(announcement);
        return ResponseEntity.ok(fileUrl);
    }
}

