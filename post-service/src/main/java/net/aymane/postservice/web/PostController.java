package net.aymane.postservice.web;

import lombok.AllArgsConstructor;
import net.aymane.postservice.entity.Post;
import net.aymane.postservice.exception.PostNotFoundException;
import net.aymane.postservice.repository.PostRepository;
import net.aymane.postservice.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostRepository postRepository;
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getpost(){
      return  postRepository.findAll();
    };
    @PostMapping("/pub")
    public ResponseEntity<Post> createPub(@RequestParam String img , @RequestParam String content){
        return ResponseEntity.ok(postService.createPub(img, content));
    }
    @GetMapping("/post/{id}")
    public  ResponseEntity<Post> getPubById(@PathVariable Long id ) throws PostNotFoundException {
        return ResponseEntity.ok(postService.getPub(id));
    }

}
