package net.aymane.userservice.web;

import lombok.RequiredArgsConstructor;
import net.aymane.userservice.client.PostRestClient;
import net.aymane.userservice.external.Pub;
import net.aymane.userservice.service.UserService;
import org.hibernate.sql.ast.tree.SqlAstTreeLogger_$logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    private PostRestClient postRestClient;
@PostMapping("/post")
    public ResponseEntity<Pub> createPub(@RequestParam String img, @RequestParam String content){
        return ResponseEntity.ok(userService.createPub(img, content));
    }
    @GetMapping("/post/{id}")
    public  ResponseEntity<Pub> getPubById(@PathVariable Long id){
        return ResponseEntity.ok(postRestClient.getPostById(id));
    }
}
