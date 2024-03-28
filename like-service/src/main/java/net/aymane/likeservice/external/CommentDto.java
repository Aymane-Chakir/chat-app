package net.aymane.likeservice.external;

import lombok.*;
import net.aymane.commentservice.external.PostResponseDto;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private Long publication_Id;
    private PostResponseDto post;
}
