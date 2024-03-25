package net.aymane.commentservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("comment.params")
@Getter @Setter  @AllArgsConstructor @NoArgsConstructor
public class DevConfig {
    private int m;
    private int n;
}
