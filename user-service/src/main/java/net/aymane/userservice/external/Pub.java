package net.aymane.userservice.external;

import lombok.*;

import java.util.Date;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Pub {
    private  Long id;
    private String caption;
    private Date createdAt;
    private String image;
}
