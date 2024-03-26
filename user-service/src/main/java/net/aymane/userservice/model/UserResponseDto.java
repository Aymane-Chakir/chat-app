package net.aymane.userservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.aymane.userservice.external.Pub;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString

public class UserResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String bio;
    @CreationTimestamp
    private Date createdAt;
    private String picture;
    private List<Pub> posts;

}
