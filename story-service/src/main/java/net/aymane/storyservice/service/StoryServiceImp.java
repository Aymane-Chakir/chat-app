package net.aymane.storyservice.service;

import lombok.AllArgsConstructor;
import net.aymane.storyservice.entity.Story;
import net.aymane.storyservice.repository.StoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StoryServiceImp  implements StoryService{
    private StoryRepository storyRepository;
    public List<Story> findActiveStories() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        return storyRepository.findByExpiredFalseAndCreatedAtAfter(twentyFourHoursAgo);
    }

    public List<Story> findExpiredStories() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        return storyRepository.findByExpiredTrueAndCreatedAtBefore(twentyFourHoursAgo);
    }

    public Story createStory(Story story) {

        story.setContent(story.getContent());
        story.setCreatedAt(LocalDateTime.now());
        story.setExpired(false);
        return storyRepository.save(story);
    }

    public void expireStories() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        List<Story> storiesToExpire = storyRepository.findByExpiredTrueAndCreatedAtBefore(twentyFourHoursAgo);
        storiesToExpire.forEach(story -> {
            story.setExpired(true);
            storyRepository.save(story);
        });
    }
}
