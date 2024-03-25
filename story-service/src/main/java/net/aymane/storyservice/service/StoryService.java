package net.aymane.storyservice.service;

import net.aymane.storyservice.entity.Story;

import java.util.List;

public interface StoryService {
    public List<Story> findActiveStories();
    public List<Story> findExpiredStories();
    public Story createStory(Story story);
    public void expireStories();
}
