package net.aymane.postservice.client;

import net.aymane.postservice.external.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "COMMENT-SERVICE")
public interface CommentServiceClient {

    @PostMapping("/comments/add")
    void addComment(@RequestBody CommentDto commentDto);
}
