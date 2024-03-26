package net.aymane.commentservice.web;

import lombok.AllArgsConstructor;
import net.aymane.commentservice.config.DevConfig;
import net.aymane.commentservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConfigController {

    private final   GlobalConfig globalConfig;
    private final DevConfig devConfig;



@GetMapping("/devConfig")
public DevConfig devConfig(){
    return devConfig;
}
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
