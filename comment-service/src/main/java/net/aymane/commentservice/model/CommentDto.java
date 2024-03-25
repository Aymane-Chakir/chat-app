package net.aymane.commentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CommentDto {
    private Long id;
    private Long publicationId;
    private String comment;
    private Long publication_Id;
}
