package net.aymane.commentservice.service;

import net.aymane.commentservice.exception.CommentNotFoundException;
import net.aymane.commentservice.external.PostResponseDto;
import net.aymane.commentservice.model.CommentDto;

import java.util.List;

public interface CommentService {



    // ------------------------------------ create post------------------------------------------------------------------
    public CommentDto addComment(CommentDto commentDto);

    //----------------------------------- update post--------------------------------------------------------------------
    public CommentDto updateComment( CommentDto commentDto) throws CommentNotFoundException;

    //------------------------------------- get all posts----------------------------------------------------------------
    public List<CommentDto> allComments() ;

    //------------------------------- delete post------------------------------------------------------------------------
    public void deleteComment(Long id) throws CommentNotFoundException;

    //------------------------------ get comment by id -----------------------------------------------------------------
    public CommentDto getComment(Long id) throws CommentNotFoundException;

    public PostResponseDto getPubById(Long id);
}
