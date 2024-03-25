package net.aymane.postservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter @Setter @ToString
public class UserResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String bio;
    private Date createdAt;
    private String picture;

}
