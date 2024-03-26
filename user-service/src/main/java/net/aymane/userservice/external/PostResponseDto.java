package net.aymane.userservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.aymane.userservice.model.UserResponseDto;

@Getter @Setter @ToString
public class PostResponseDto {
    private  Long id;
    private String caption;
    private String image;
    private Boolean active;
    //private List<Comment> comment;
    private UserResponseDto User;
    private Long User_id;
}
