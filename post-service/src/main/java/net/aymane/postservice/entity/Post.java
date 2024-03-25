package net.aymane.postservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.aymane.postservice.external.CommentDto;
import net.aymane.postservice.external.User;
import net.aymane.postservice.external.UserResponseDto;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String caption;
    @CreationTimestamp
    private Date createdAt;
    private String image;
//    @Column(nullable = false)
//    private double like ;

    private Boolean active;
    @Transient
  private List<CommentDto> comment;
    @Transient
    private UserResponseDto User;
    private Long User_id;
}
