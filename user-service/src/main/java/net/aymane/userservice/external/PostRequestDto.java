package net.aymane.userservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.aymane.userservice.model.UserResponseDto;

import java.util.Date;

@Getter @Setter @ToString
public class PostRequestDto {
    private  Long id;
    private String caption;
    private Date createdAt;
    private String image;
//    @Column(nullable = false)
//    private double like ;
    private Boolean active;
    //private List<Comment> comment;
    private UserResponseDto userResponseDto;
    private Long User_id;
}
