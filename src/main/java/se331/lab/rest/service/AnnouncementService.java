package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAllAnnouncements();
    Announcement addAnnouncement(Announcement announcement);
}
