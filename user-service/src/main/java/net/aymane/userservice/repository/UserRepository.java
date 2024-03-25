package net.aymane.userservice.repository;

import net.aymane.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    List<User> findByFirstnameContains(String kw);
}
