package net.aymane.storyservice.web;

import lombok.AllArgsConstructor;
import net.aymane.storyservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class StoryConfigController {

    private GlobalConfig globalConfig;

    @Value("${story.params.c}")
    private int c;
    @Value("${story.params.d}")
    private int d;

    @GetMapping("/storyConfig")
    public Map<String,Integer> storyConfig(){
        return Map.of("c",c,"d",d);
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

}
