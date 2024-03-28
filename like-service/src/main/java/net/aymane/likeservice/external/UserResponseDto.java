package net.aymane.likeservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString

public class UserResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String bio;

    private String picture;


}
