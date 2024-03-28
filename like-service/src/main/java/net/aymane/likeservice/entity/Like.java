package net.aymane.likeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.aymane.likeservice.external.CommentDto;
import net.aymane.likeservice.external.PostResponseDto;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean active;
    @Transient
    private CommentDto comment;
    @Transient
    private PostResponseDto postResponseDto;

}
