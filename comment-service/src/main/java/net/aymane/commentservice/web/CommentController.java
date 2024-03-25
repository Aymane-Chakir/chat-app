package net.aymane.commentservice.web;

import net.aymane.commentservice.exception.CommentNotFoundException;
import net.aymane.commentservice.model.CommentDto;
import net.aymane.commentservice.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommentController {
    private CommentService commentService;
// --------------------------------------------- add comment -----------------------------------------------------------
    @PostMapping("/comments/add")
    public void addComment(@RequestBody CommentDto commentDto) {
            commentService.addComment(commentDto);
    }

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
}
