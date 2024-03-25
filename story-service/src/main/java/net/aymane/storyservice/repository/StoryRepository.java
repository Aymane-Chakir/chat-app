package net.aymane.storyservice.repository;

import net.aymane.storyservice.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {
    List<Story> findByExpiredTrueAndCreatedAtBefore(LocalDateTime dateTime);
    List<Story> findByExpiredFalseAndCreatedAtAfter(LocalDateTime dateTime);
}
