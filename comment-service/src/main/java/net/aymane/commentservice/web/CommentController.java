package net.aymane.commentservice.web;

import lombok.AllArgsConstructor;
import net.aymane.commentservice.entity.Comment;
import net.aymane.commentservice.exception.CommentNotFoundException;
import net.aymane.commentservice.external.PostResponseDto;
import net.aymane.commentservice.model.CommentDto;
import net.aymane.commentservice.repository.CommentRepository;
import net.aymane.commentservice.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;
    private final CommentRepository commentRepository;
// --------------------------------------------- add comment -----------------------------------------------------------
    @PostMapping("/comments/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addComment(@RequestParam(name = "id") Long id,@RequestBody CommentDto commentDto) {
        commentDto.setPublication_Id(id);
           CommentDto commentDto1= commentService.addComment(commentDto);
           return commentDto1;
    }
//    @ResponseStatus(HttpStatus.CREATED)
//public void addComment(Comment comment){
//        commentRepository.save(comment);
//    }
    //------------------------------------------  get comment by id-----------------------------------------------------
    @GetMapping("/comment/{id}")
    public CommentDto getComment(@PathVariable Long id) throws CommentNotFoundException {
        CommentDto commentDto = commentService.getComment(id);
        return commentDto;
    }
    //------------------------------------------------- get all comment------------------------------------------------
    @GetMapping("/comments")
    public List<CommentDto> getComments(){
        List<CommentDto> commentDtoList = commentService.allComments();
        return  commentDtoList;
    }
    //------------------------------------------------ delete comment---------------------------------------------------
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id) throws CommentNotFoundException {
        commentService.deleteComment(id);
    }
    //------------------------------------------------- update comment--------------------------------------------------
    @PutMapping("/comment/{id}")
    public CommentDto updateComment(@PathVariable Long id,@RequestBody CommentDto commentDto) throws CommentNotFoundException {
        commentDto.setId(id);
        return commentService.updateComment(commentDto);
    }

// ------------------------------------ get post by id------------------------------------------------------------------
    @GetMapping("/post/{id}")
    public ResponseEntity<PostResponseDto> getPubById(@PathVariable Long id ){
        return ResponseEntity.ok(commentService.getPubById(id));
    };
}
