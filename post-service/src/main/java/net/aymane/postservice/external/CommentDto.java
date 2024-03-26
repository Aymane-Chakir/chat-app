package net.aymane.postservice.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CommentDto {
    private Long id;
    private String content;
    private Long publication_Id;
}
