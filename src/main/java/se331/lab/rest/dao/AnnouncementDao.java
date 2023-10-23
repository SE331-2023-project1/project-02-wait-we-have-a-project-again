package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Announcement;

public interface AnnouncementDao {
    Page<Announcement> getAnnouncements(Pageable pageRequest);
    Announcement save(Announcement announcement);
}
