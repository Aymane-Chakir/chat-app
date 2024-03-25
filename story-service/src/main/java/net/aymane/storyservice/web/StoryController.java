package net.aymane.storyservice.web;

import lombok.AllArgsConstructor;
import net.aymane.storyservice.entity.Story;
import net.aymane.storyservice.service.StoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StoryController {
    private StoryService storyService;
    @GetMapping("/active")
    public List<Story> getActiveStories() {
        return storyService.findActiveStories();
    }

    @GetMapping("/expired")
    public List<Story> getExpiredStories() {
        return storyService.findExpiredStories();
    }

    @PostMapping("/create")
    public Story createStory(@RequestParam(name = "id") Long id , @RequestBody Story story) {
        story.setUser_id(id);
        return storyService.createStory(story);
    }
}
