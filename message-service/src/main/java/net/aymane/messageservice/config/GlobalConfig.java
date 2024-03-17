package net.aymane.messageservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
