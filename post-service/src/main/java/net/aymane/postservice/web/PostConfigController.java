package net.aymane.postservice.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.aymane.postservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class PostConfigController {
    private  GlobalConfig globalConfig;

    @Value("${post.params.w}")
    private Integer w;
    @Value("${Post.params.x}")
    private Integer x;
    @GetMapping("/testConfig")
    public Map<String, Integer> test(){
        return Map.of("w",w,"x",x);
    }



@GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
