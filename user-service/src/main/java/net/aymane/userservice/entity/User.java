package net.aymane.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.aymane.userservice.external.Pub;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "insert your first name")
    private String firstname;
    @NotBlank(message = "insert your last name")
    private String lastname;
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @Size(min = 6,max = 12,message = "min size is 6 and max size is 12")
    private String password;
    @NotNull
    private String phoneNumber;
    private String bio;
    @CreationTimestamp
    private Date createdAt;
    private String picture;
    @Transient
//    @ElementCollection
    private List<Pub> posts;

//@JdbcTypeCode(SqlTypes.JSON)
//    @PrimaryKeyJoinColumn
@Transient
    private List<User> followers;
//    @JdbcTypeCode(SqlTypes.JSON)
//    @PrimaryKeyJoinColumn
    @Transient
    private  List<User> following;
//    private List<Story> stories;
//    private List<Message> messageSent;
//    private List<Message> messageRecieved;
}
