package net.aymane.postservice.web;

import net.aymane.postservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PostConfigController {

    @Value("${post.params.c}")
    private Integer c;
    @Value("${Post.params.d}")
    private Integer d;
    @GetMapping("/testConfig")
    public Map<String, Integer> test(){
        return Map.of("c",c,"d",d);
    }

    @Autowired
    private GlobalConfig globalConfig;
@GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
