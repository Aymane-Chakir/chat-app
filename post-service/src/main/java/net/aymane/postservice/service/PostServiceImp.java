package net.aymane.postservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aymane.postservice.entity.Post;
import net.aymane.postservice.exception.PostNotFoundException;
import net.aymane.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImp implements PostService{
    private PostRepository postRepository;


    @Override
    public Post createPub(String img,String caption) {
        log.info("publication created successfully");
        Post post= Post.builder()
                .createdAt(new Date())
                .image(img)
                .caption(caption)
                .build();
        return postRepository.save(post);
    }

    @Override
    public Post getPub(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(()->new PostNotFoundException("post not found "));
        return post;
    }
}
