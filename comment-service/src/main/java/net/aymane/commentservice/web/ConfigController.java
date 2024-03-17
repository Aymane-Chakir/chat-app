package net.aymane.commentservice.web;

import lombok.AllArgsConstructor;
import net.aymane.commentservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConfigController {

    private  GlobalConfig globalConfig;

    @Value("${comment.params.m}")
    private int m;
    @Value("${comment.params.n}")
    private int n;

    @GetMapping("/commentConfig")
    public Map<String,Integer> commentParam(){
        return Map.of("m",m,"n",n);
    }
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
