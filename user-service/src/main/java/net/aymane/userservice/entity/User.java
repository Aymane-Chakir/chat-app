package net.aymane.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String bio;
    @CreationTimestamp
    private Date createdAt;
    private String picture;
//    private List<Publication> posts;
//@JdbcTypeCode(SqlTypes.JSON)
    @PrimaryKeyJoinColumn
    @Transient
    private List<User> followers;
//    @JdbcTypeCode(SqlTypes.JSON)
    @PrimaryKeyJoinColumn
    @Transient
    private  List<User> following;
//    private List<Story> stories;
//    private List<Message> messageSent;
//    private List<Message> messageRecieved;
}
