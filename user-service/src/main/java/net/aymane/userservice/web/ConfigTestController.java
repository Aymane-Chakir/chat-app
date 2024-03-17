package net.aymane.userservice.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.aymane.userservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class ConfigTestController {

private GlobalConfig globalConfig;

//    @Value("${global.params.p1}")
//    private int p1;
//    @Value("${global.params.p2}")
//    private  int p2;
   @Value("${user.params.a}")
   private int a;
   @Value("${user.params.b}")
    private  int b;
   @GetMapping("/userConfig")
   public Map<String, Integer> userConfig(){
       return Map.of("a",a=11,"b",b=22);
   }
   @GetMapping("/globalConfig")
   public GlobalConfig globalConfig(){
       return globalConfig;
   }
}
