package net.aymane.postservice.external;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String bio;
    @CreationTimestamp
    private Date createdAt;
    private String picture;
}
