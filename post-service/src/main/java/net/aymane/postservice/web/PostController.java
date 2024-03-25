package net.aymane.postservice.web;
import lombok.AllArgsConstructor;
import net.aymane.postservice.client.CommentServiceClient;
import net.aymane.postservice.exception.PostNotFoundException;
import net.aymane.postservice.external.CommentDto;
import net.aymane.postservice.model.PostRequestDto;
import net.aymane.postservice.model.PostResponseDto;
import net.aymane.postservice.repository.PostRepository;
import net.aymane.postservice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class PostController {
    private PostRepository postRepository;
    private PostService postService;
    private CommentServiceClient commentServiceClient;
//------------------------------- get all publication-------------------------------------------------------------------
    @GetMapping("/posts")
    public ResponseEntity<?> getPost() throws PostNotFoundException {
      List<PostResponseDto> responseDtoList = postService.allPosts();
      Map<String ,Object> response= new HashMap<>();
      response.put("status","201");
      response.put("data",responseDtoList);
      return ResponseEntity.status(HttpStatus.OK).body(response);
    };

//------------------------------ create post ---------------------------------------------------------------------------
    @PostMapping("/post")
    public  ResponseEntity<PostResponseDto> createPost(@RequestParam(name = "id") Long id , @RequestBody PostRequestDto postRequestDto){
        postRequestDto.setUser_id(id);
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }
// --------------------------------- get post by id --------------------------------------------------------------------
    @GetMapping("/post/{id}")
    public  ResponseEntity<?> getPubById(@PathVariable Long id ) throws PostNotFoundException {
        PostResponseDto postResponseDto = postService.getPub(id);
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",postResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/post/{id}/like")
    public void like(@PathVariable Long id) throws PostNotFoundException {
         postService.like(id);
    }
    @PutMapping("/post/{id}")
    public  ResponseEntity<?> updatePost(@PathVariable Long id , @RequestBody PostRequestDto requestDto) throws PostNotFoundException {
        requestDto.setId(id);
        PostResponseDto postResponseDto = postService.updatePost(requestDto);
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",postResponseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    // ------------------------------------------------ delete publication----------------------------------------------
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id ) throws PostNotFoundException {
        postService.deletePost(id);
        Map<String,String> response = new HashMap<>();
        response.put("status","201");
        response.put("message","user deleted");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
@GetMapping("/post/search")
    public ResponseEntity<?> searchPost(@RequestParam(name = "kw") String kw) throws PostNotFoundException {
        List<PostResponseDto> responseDtoList = postService.searchPost(kw);
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",responseDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //------------------------------ add comment------------------------------------------------------------------------
    @PostMapping("/comments")
    public void addComment(@RequestParam Long id, @RequestBody CommentDto comment) {
        comment.setPublicationId(id);
        commentServiceClient.addComment(comment);
    }
}
