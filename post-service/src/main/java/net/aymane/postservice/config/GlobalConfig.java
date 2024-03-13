package net.aymane.postservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("global.params")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private Integer p1;
    private Integer p2;
}
