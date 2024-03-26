package net.aymane.postservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.aymane.postservice.external.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "COMMENT-SERVICE")
public interface CommentServiceClient {

    @PostMapping("/comments/add")
    @CircuitBreaker(name = "commentService")
    ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto);
}
