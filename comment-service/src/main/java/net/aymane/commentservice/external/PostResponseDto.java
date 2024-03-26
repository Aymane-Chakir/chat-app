package net.aymane.commentservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class PostResponseDto {
    private  Long id;
    private String caption;
    private String image;
    private Boolean active;
    private Long User_id;
}
