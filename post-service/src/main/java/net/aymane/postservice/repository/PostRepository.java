package net.aymane.postservice.repository;

import net.aymane.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}