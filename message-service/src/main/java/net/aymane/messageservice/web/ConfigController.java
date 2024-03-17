package net.aymane.messageservice.web;

import lombok.AllArgsConstructor;
import net.aymane.messageservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConfigController {

    @Value("${message.params.h}")
    private int h;
    @Value("${message.params.j}")
    private int j;

    private GlobalConfig globalConfig;

    @GetMapping("/messageConfig")
    public Map<String,Integer> messageConfig(){
        return Map.of("h",h,"j",j);
    }
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

}
