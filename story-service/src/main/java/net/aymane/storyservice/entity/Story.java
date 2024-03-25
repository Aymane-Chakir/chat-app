package net.aymane.storyservice.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  @CreationTimestamp
  @Column(nullable = false)
    private LocalDateTime createdAt;
  @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private boolean expired;
    private Long user_id;
//    private Integer like;
//    private  User auteur;

}
