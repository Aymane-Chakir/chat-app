package net.aymane.userservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.aymane.userservice.external.PostRequestDto;
import net.aymane.userservice.external.PostResponseDto;
import net.aymane.userservice.external.Pub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@RestController
@FeignClient(name = "POST-SERVICE")

public interface PostRestClient {
    @PostMapping("/post")
    @CircuitBreaker(name = "postService")
    public ResponseEntity<PostResponseDto> createPost(@RequestParam(name = "id") Long id , @RequestBody PostRequestDto postRequestDto);

    @GetMapping("/post/{id}")
    @CircuitBreaker(name = "postService")
    ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id);
    @GetMapping("/posts")
    @CircuitBreaker(name = "postService")
    public ResponseEntity<List<PostResponseDto>> getPost();

}
