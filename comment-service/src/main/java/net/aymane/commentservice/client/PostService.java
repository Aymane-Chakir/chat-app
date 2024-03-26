package net.aymane.commentservice.client;

import net.aymane.commentservice.external.PostResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "POST-SERVICE")
public interface PostService {
    @GetMapping("/post/{id}")
    public  ResponseEntity<PostResponseDto> getPubById(@PathVariable Long id );
}
