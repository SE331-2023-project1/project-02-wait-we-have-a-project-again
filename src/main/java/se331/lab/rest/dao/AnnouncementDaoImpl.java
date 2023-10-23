package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Announcement;
import se331.lab.rest.repository.AnnouncementRepository;

@Repository
@RequiredArgsConstructor
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;

    @Override
    public Page<Announcement> getAnnouncements(Pageable pageRequest) {
        return announcementRepository.findAll(pageRequest);
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
}
